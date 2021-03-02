package com.yogiyo.review.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yogiyo.review.form.CommentForm;
import com.yogiyo.review.form.ReviewForm;
import com.yogiyo.review.service.ReviewStoreService;
import com.yogiyo.review.service.ReviewUserService;
import com.yogiyo.review.service.ReviewService;
import com.yogiyo.review.vo.ReviewStore;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;
import com.yogiyo.review.vo.Review;

@Controller
public class ReviewController {
	
	@Value("${directory.review.photo}") 
	String directory = "C:/final/hta_final_project/src/main/resources/static/resource/images";
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReviewStoreService storeService;
	
	@Autowired
	ReviewUserService reviewUserService;

	
	// 리뷰의 메인페이지를 보여준다, 모든 리뷰리스트를 보여준다
	//http://localhost/review/main.do?storeNo=93&picture=A
	@RequestMapping("/main.do")
	public String reviewMain(@RequestParam(name = "storeNo", required = true) String storeNo, 
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			Model model) {
		ReviewStore store = storeService.getStoreByNo(storeNo);
		//System.out.println("메인화면에 들어갔을 때 storeNo로 store가 찍히는지 확인: " + storeNo + store);
		model.addAttribute("store", store);
		//System.out.println("store가 model에 들어갔는지 확인: " + store);
		
		Map<String, Object> map = new HashMap<>();
		map.put("storeNo", storeNo);
		map.put("page", page);
		
		Map<String, Object> result = reviewService.getReviewByCondition(map);
		model.addAttribute("reviews", result.get("reviews"));
		return "review/main";
	}

	
	// 리뷰등록 페이지로 이동
	@RequestMapping("/review/form.do")
	public String reviewform(@RequestParam(name = "storeNo", required = true) String storeNo, 
			Model model) {
		ReviewStore store = storeService.getStoreByNo(storeNo);
		model.addAttribute("store", store);
		return "review/form";
	}
	
	// 리뷰를 등록하고 submit제출을 누르면 실행될 메소드다
	@RequestMapping("/review/create.do")
	public String createReview(@RequestParam(name = "storeNo", required = true) String storeNo, 
			ReviewForm reviewForm) throws FileNotFoundException, IOException {
		System.out.println("신규 리뷰 정보: " + reviewForm);
		// Review객체를 생성해서 ReviewForm 객체의 값을 복사한다
		// MultipartFile 타입의 객체가 복사되지 않도록 한다(Review와 ReviewForm에서 각각 다른 이름을 사용한다)
		User loginedUser = (User) SessionUtils.getAttribute("LOGINED_USER");
		System.out.println(loginedUser);
		int userNo = loginedUser.getNo();
		Review review = new Review();
		BeanUtils.copyProperties(reviewForm, review);
		review.setUserNo(userNo);
		review.setStoreNo(storeNo);
		review.setAvgScore((reviewForm.getTasteScore() + reviewForm.getQuantityScore() + reviewForm.getDeliveryScore())/3);
		System.out.println("userNo를 review안에 담는다: " + review.getUserNo());
		//System.out.println("avgScore를 review안에 담는다: " + review.getAvgScore());
		
		System.out.println("리뷰폼 복사해서 review 객체에 넣기: " + review);	 
		
		// 클라이언트에서 업로드한 리뷰사진을 지정된 위치의 디렉토리에 복사하기
		MultipartFile photo1 = reviewForm.getReviewPhoto1();
		MultipartFile photo2 = reviewForm.getReviewPhoto2();
		MultipartFile photo3 = reviewForm.getReviewPhoto3();
		
		if (!photo1.isEmpty()) {
			// 업로드된 파일이름 획득
			String photoname = photo1.getOriginalFilename();
			// 원래 파일명에 유닉스타임값을 붙여서 파일이름이 중복되지 않도록 한다
			photoname = System.currentTimeMillis() + photoname;
			// 지정된 디렉토리에 해당 파일명으로 파일객체 생성
			File file = new File(directory, photoname);
			// MultipartFile객체의 getInputStream() 메소드로 업로드된 첨부파일을 읽어서
			// FileOutputStream으로 지정된 File객체가 가리키는 곳에 업로드된 첨부파일을 복사한다
			FileCopyUtils.copy(photo1.getInputStream(), new FileOutputStream(file));
			// 파일의 이름을 db에 저장하기 위해 Review객체에 저장한다
			review.setPhoto1(photoname);
		}
		if (!photo2.isEmpty()) {
			String photoname = photo2.getOriginalFilename();
			photoname = System.currentTimeMillis() + photoname;
			File file = new File(directory, photoname);
			FileCopyUtils.copy(photo2.getInputStream(), new FileOutputStream(file));
			review.setPhoto2(photoname);
		}
		if (!photo3.isEmpty()) {
			String photoname = photo3.getOriginalFilename();
			photoname = System.currentTimeMillis() + photoname;
			File file = new File(directory, photoname);
			FileCopyUtils.copy(photo3.getInputStream(), new FileOutputStream(file));
			review.setPhoto3(photoname);
		}
		
		reviewService.createMyReview(review);
		System.out.println("review에 userNo가 들어갔는지 확인: " + review.getUserNo());
		System.out.println("인서트 후: "+review);
		
		return "redirect:/des.do?storeNo=" + storeNo;	
		
	}
	
	@RequestMapping("/review/commentform.do")
	public String commentform(@RequestParam(name = "storeNo", required = true) String storeNo, 
			@RequestParam(name = "reviewNo", required = true) int reviewNo, 
			@RequestParam(name = "ownerNo", required = true) String ownerNo,
			Model model) {
		
		Review review = reviewService.getReviewByReviewNo(reviewNo);
		model.addAttribute("review", review);
		
		return "review/commentform";
	}
	
	// 말이 create지, 생성이 아닌 기존 review테이블에 
	// ownerNo, ownerComment, ownerCommentCreatedDate 값을 update한다
	@RequestMapping("/review/createComment.do")
	public String createComment(@RequestParam(name = "reviewNo", required = true) int reviewNo, 
			@RequestParam(name = "ownerNo", required = true) String ownerNo, 
			@RequestParam(name = "storeNo", required = true) String storeNo, 
			CommentForm commentForm) {
		System.out.println("reviewNo찍히는지 확인: " + reviewNo);				//완
		System.out.println("ownerNo찍히는지 확인: " + ownerNo);
		System.out.println("commentForm찍히는지 확인: " + commentForm);
		Review review = reviewService.getReviewByReviewNo(reviewNo);
		String ownerComment = commentForm.getOwnerComment();
		review.setOwnerNo(ownerNo);
		review.setOwnerComment(ownerComment);
		reviewService.createComment(review);
		System.out.println("createComment에 정보가 들어갔는지 확인: " + review);
		
		return "redirect:/des.do?storeNo=" + storeNo;	
	}
	
	
	@RequestMapping("/review/delete.do")
	public String deleteMyReview(@RequestParam(name = "reviewNo", required = true) int reviewNo, 
			@RequestParam(name = "storeNo", required = true) String storeNo) {
		
		Review review = reviewService.getReviewByReviewNo(reviewNo);
		reviewService.deleteMyReview(review);
		
		return "redirect:/des.do?storeNo=" + storeNo;	
	}
	
}
