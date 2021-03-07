package com.yogiyo.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogiyo.review.service.ReviewService;
import com.yogiyo.review.service.ReviewStoreService;
import com.yogiyo.review.vo.ReviewStore;
import com.yogiyo.search.service.CategoryService;
import com.yogiyo.search.service.StoreService;
import com.yogiyo.search.vo.Category;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;

@Controller
public class SearchController {
	@Autowired
	StoreService storeService;
	@Autowired
	CategoryService categoryService;
	
	// 음식점 목록 나열
	@RequestMapping("/list.do")
    public String list(@RequestParam(name="ctgno", required=false, defaultValue="1") int categoryNo,
	         @RequestParam(name="page", required=false, defaultValue="1") int pageNo,          
	         @RequestParam(name="rows", required=false, defaultValue="4") int rows,
	         @RequestParam(name="sort", required=false, defaultValue="basic") String sort,
	         @RequestParam(name="address", required=false) String address,
	         @RequestParam(name="origin", required=false) String origin,
	         @RequestParam(name="keyword", required=false) String keyword,
	         Model model) {
		
		SessionUtils.setAttribute("origin", origin);
		
		// 음식점의 카테고리 정보 조회하기
		Category category = storeService.getCategory(categoryNo);
		model.addAttribute("category", category);
		
		// 음식점 검색 조건을 저장하는 Map 객체를 생성
		Map<String, Object> condition = new HashMap<>();
		condition.put("categoryNo", categoryNo);				// 카테고리 번호
		condition.put("sort", sort);							// 정렬
		if (address != null && !address.isEmpty()) {
			condition.put("address", address);					// 주소
		}
		if (keyword != null && !keyword.isEmpty()) {
			condition.put("keyword", keyword);					// 키워드
		}
		condition.put("pageNo", pageNo);						// 요청한 페이지번호
		condition.put("rows", rows);							// 한 화면에 표시할 음식점의 갯수
		condition.put("begin", (pageNo - 1)*rows + 1);     		 // 조회 시작 행 번호
		condition.put("end", pageNo*rows);             	   		 // 조회 마지막 행 번호
		
		// 뷰에 표시할 음식점 정보와 페이징 정보를 조회한다.
		Map<String, Object> resultMap = storeService.getStores(condition);
		
		// 뷰에 전달할 데이터를 모델에 담기
		model.addAttribute("page", resultMap.get("pagination"));
		model.addAttribute("stores", resultMap.get("stores"));
		
		return "stores/list";							// WEB-INF/views/stores/list.jsp로 내부이동?
		
	}
	
	//리뷰관련 서비스 추가
	@Autowired
	ReviewService reviewService;
	@Autowired
	ReviewStoreService reviewStoreService;
	
	// 상점 디테일
	@RequestMapping("/des.do")
	public String detail(@RequestParam("storeNo") String storeNo, 
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
		
		// 페이지 파라미터, 모델, 그리고 리뷰를 조회할 map추가 
		ReviewStore store = reviewStoreService.getStoreByNo(storeNo);
		model.addAttribute("store", store);
		
		Map<String, Object> map = new HashMap<>();
		map.put("storeNo", storeNo);
		map.put("page", page);
		
		Map<String, Object> result = reviewService.getReviewByCondition(map);
		model.addAttribute("reviews", result.get("reviews"));
		model.addAttribute("userId", result.get("userId"));
		
		// 유저의 주문내역을 모델에 담기
		//List<ReviewOrderItem> orderItemList = reviewOrderService.getOrderInfoByUserNo(userNo, orderNo);
		//model.addAttribute("orderItemList", orderItemList);
		
		return "stores/des";
	}
			
}
