package com.yogiyo.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yogiyo.review.service.ReviewService;
import com.yogiyo.review.service.ReviewStoreService;
import com.yogiyo.review.vo.Review;
import com.yogiyo.review.vo.ReviewStore;

@RestController
@RequestMapping("/api")
public class AjaxReviewController {

	@Autowired
	ReviewService reviewService;
	@Autowired
	ReviewStoreService reviewStoreService;
	
	@GetMapping("/store.do")
	public ReviewStore getStore(@RequestParam("storeNo") String storeNo) {
		return reviewStoreService.getStoreByNo(storeNo);
	}
	
	@GetMapping("/reviews.do")
	public Map<String, Object> getReviews(@RequestParam("storeNo") String storeNo, 
			@RequestParam(name="page", required=false, defaultValue="1") int page) {
		Map<String, Object> map = new HashMap<>();
		map.put("storeNo", storeNo);
		map.put("page", page);
		
		return reviewService.getReviewByCondition(map);
		
	}
	
	@GetMapping("/review.do")
	public Review getReviews(@RequestParam(name = "reviewNo", required = true) int reviewNo) {

		return reviewService.getReviewByReviewNo(reviewNo);
	}
}
