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
import com.yogiyo.review.service.ReviewOrderService;
import com.yogiyo.review.service.ReviewService;
import com.yogiyo.review.vo.ReviewStore;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;
import com.yogiyo.review.vo.Review;
import com.yogiyo.review.vo.ReviewOrderItem;

@Controller
public class ReviewController {
	
	@Value("${directory.review.photo}") 
	String directory = "C:/final/hta_final_project/src/main/resources/static/resource/images";
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReviewStoreService storeService;
	
	@Autowired
	ReviewOrderService reviewOrderService;

	/**
	 * 리뷰의 메인페이지를 보여준다, 모든 리뷰리스트를 보여준다
	 * @param storeNo
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/main.do")
	public String reviewMain(@RequestParam(name = "storeNo", required = true) String storeNo, 
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			Model model) {
		// 사장정보 획득
		String ownerNo = (String) com.yogiyo.owner.utils.SessionUtils.getAttribute("OWNER_NO");
		model.addAttribute("ownerNo", ownerNo);
		System.out.println("오너넘버 획득: " + ownerNo);
		
		// 유저정보 획득
		User loginedUser = (User) SessionUtils.getAttribute("LOGINED_USER");
		// String userNo = loginedUser.getNo();
		String userNo = String.valueOf(((User)SessionUtils.getAttribute("LOGINED_USER")).getNo());
		System.out.println("유저넘버 : " +userNo);
		model.addAttribute("user", loginedUser);
				
		ReviewStore store = storeService.getStoreByNo(storeNo);
		//System.out.println("메인화면에 들어갔을 때 storeNo로 store가 찍히는지 확인: " + storeNo + store);
		model.addAttribute("store", store);
		//System.out.println("store가 model에 들어갔는지 확인: " + store);
		
		Map<String, Object> map = new HashMap<>();
		map.put("storeNo", storeNo);
		map.put("page", page);
		
		Map<String, Object> result = reviewService.getReviewByCondition(map);
		model.addAttribute("reviews", result.get("reviews"));
		model.addAttribute("userId", result.get("userId"));
		
		// 유저의 주문내역을 모델에 담기
		ReviewOrderItem orderItem = reviewOrderService.getOrderInfoByUserNo(userNo);
		model.addAttribute("orderItem", orderItem);
		
		return "review/main";
	}
	
	/**
	 * 리뷰 등록 페이지로 이동한다
	 * @param storeNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/review/form.do")
	public String reviewform(@RequestParam(name = "storeNo", required = true) String storeNo, 
			Model model) {
		ReviewStore store = storeService.getStoreByNo(storeNo);
		model.addAttribute("store", store);
		return "review/form";
	}
	
	/**
	 * 리뷰를 등록하고 submit하면 실행될 메소드
	 * @param storeNo
	 * @param reviewForm
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@RequestMapping("/review/create.do")
	public String createReview(@RequestParam(name = "storeNo", required = true) String storeNo, 
			ReviewForm reviewForm) throws FileNotFoundException, IOException {
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
	
	/**
	 * 사장이 코멘트를 작성할 페이지로 이동한다
	 * @param storeNo
	 * @param reviewNo
	 * @param ownerNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/review/commentform.do")
	public String commentform(@RequestParam(name = "storeNo", required = true) String storeNo, 
			@RequestParam(name = "reviewNo", required = true) int reviewNo, 
			@RequestParam(name = "ownerNo", required = true) String ownerNo,
			Model model) {
		
		Review review = reviewService.getReviewByReviewNo(reviewNo);
		model.addAttribute("review", review);
		
		return "review/commentform";
	}
	
	/**
	 * 사장의 코멘트를 생성한다. 말이 create지 생성이 아닌 기존 review테이블에 
	 * ownerNo, ownerComment, ownerCommentCreatedDate 값을 update한다
	 * @param storeNo
	 * @param reviewNo
	 * @param ownerNo
	 * @param commentForm
	 * @return
	 */
	@RequestMapping("/review/createComment.do")
	public String createComment(@RequestParam(name = "storeNo", required = true) String storeNo, 
			@RequestParam(name = "reviewNo", required = true) int reviewNo, 
			@RequestParam(name = "ownerNo", required = true) String ownerNo, 
			CommentForm commentForm) {
		System.out.println("reviewNo찍히는지 확인: " + reviewNo);				
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
	
	/**
	 * 내가 쓴 리뷰를 삭제한다(비활성화 해서, 클린리뷰 페이지에 보이지 않게 처리한다)
	 * @param reviewNo
	 * @param storeNo
	 * @return
	 */
	@RequestMapping("/review/delete.do")
	public String deleteMyReview(@RequestParam(name = "reviewNo", required = true) int reviewNo, 
			@RequestParam(name = "storeNo", required = true) String storeNo) {
		
		Review review = reviewService.getReviewByReviewNo(reviewNo);
		reviewService.deleteMyReview(review);
		
		return "redirect:/des.do?storeNo=" + storeNo;	
	}
	
	
}
