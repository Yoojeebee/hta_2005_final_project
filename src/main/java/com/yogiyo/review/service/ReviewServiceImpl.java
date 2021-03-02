package com.yogiyo.review.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.review.dao.ReviewStoreDao;
import com.yogiyo.review.dao.ReviewDao;
import com.yogiyo.review.dto.ReviewPagination;
import com.yogiyo.review.exception.MismatchUserException;
import com.yogiyo.review.vo.ReviewStore;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;
import com.yogiyo.review.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	// @Autowired로 조립시키는 것은 Dao, Service 와 같은 기능이 구현된 클래스다.
	// VO와 DTO는 절대로 @Autowired로 조립하면 안됨
	
	@Autowired
	ReviewDao reviewDao;

	@Autowired
	ReviewStoreDao storeDao;
	
	@Override
	public void createMyReview(Review review) {
		reviewDao.createMyReview(review);
		ReviewStore store = storeDao.getStoreByNo(review.getStoreNo());
		int storeReviewCount = store.getReviewAcc();
		int taste = (store.getTaste()*storeReviewCount + review.getTasteScore()) / (storeReviewCount + 1);
		int quan = (store.getQuality()*storeReviewCount + review.getQuantityScore()) / (storeReviewCount + 1);
		int del = (store.getDelivery()*storeReviewCount + review.getDeliveryScore()) / (storeReviewCount + 1);
		int avg = (int)(taste + quan + del) / 3;
		store.setReviewAcc(storeReviewCount + 1);
		store.setTaste(taste);
		store.setQuality(quan);
		store.setDelivery(del);
		store.setAvg(avg);
		
		storeDao.updateStoreScore(store);
	}
	
	@Override
	public void createComment(Review review) {
		reviewDao.createComment(review);
	}
	
	@Override
	public Map<String, Object> getReviewByCondition(Map<String, Object> condition) {
		Map<String, Object> result = new HashMap<String, Object>();
        // 검색조건에 해당하는 리뷰행의 개수를 조회한다. 
		int totalRows = reviewDao.getReviewCnt(condition);
		// 검색조건에 해당하는 코멘트의 개수를 조회한다.
		int totalComment = reviewDao.getCommentCnt(condition);
		// 페이징처리 객체 생성하고, 초기화한다.
		int currentPage = (Integer) condition.get("page");
		ReviewPagination pagination = new ReviewPagination(currentPage, totalRows);
		
		int begin = (currentPage - 1)*pagination.getRowsPerPage() + 1;
		int end = currentPage*pagination.getRowsPerPage();
	
		// 컨디션 안에 담는다
		condition.put("begin", begin);
		condition.put("end", end);
		condition.put("totalComment", totalComment);
		
		// 조건에 맞는 리뷰 리스트 조회하기
		List<Review> reviews = reviewDao.getReviews(condition);
	
		
		// 맵에 조회된 정보 담기
		result.put("reviews", reviews);
		result.put("pagination", pagination);
		return result;
	}
	
	@Override
	public Review getReviewByStoreNo(String storeNo) {
		Review review = reviewDao.getReviewByStoreNo(storeNo);
		return review;
	}
	
	@Override
	public Review getReviewByReviewNo(int reviewNo) {
		return reviewDao.getReviewByReviewNo(reviewNo);
	}
	
	@Override
	public List<Review> getAllReviews() {
		return reviewDao.getAllReviews();
	}
	
	@Override
	public void deleteMyReview(Review review) {
		reviewDao.deleteMyReview(review);
	}
	
}
