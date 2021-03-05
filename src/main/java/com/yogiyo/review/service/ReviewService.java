package com.yogiyo.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.yogiyo.review.vo.Review;
import com.yogiyo.review.vo.ReviewOrderItem;


@Transactional
public interface ReviewService {

	//reviewDAO.saveDivisionData 에서 처리한 쿼리문이 정상적으로 완료가 되고, 
	//reviewDAO.saveextensionTarget 에서 처리 도중 에러가 났을 때
	//reviewDAO.saveDivisionData 에서 처리한 쿼리를 자동 rollback 해주기 위해 사용된다.

	/**
	 * 조건(특정 상점)에 해당하는 리뷰를 반환한다
	 * @param condition
	 * @return Map<String, Object>
	 */
	Map<String, Object> getReviewByCondition(Map<String, Object> condition);	
	
	/**
	 * 리뷰 작성하기
	 * @param review
	 */
	void createMyReview(Review review);					

	/**
	 * 코멘트 작성하기
	 * @param review
	 */
	void createComment(Review review);
	
	/**
	 * storeNo에 해당하는 리뷰 반환하기
	 * @param storeNo
	 * @return Review
	 */
	Review getReviewByStoreNo(String storeNo);
	
	/**
	 * reviewNo에 해당하는 리뷰 반환하기
	 * @param reviewNo
	 * @return Review
	 */
	Review getReviewByReviewNo(int reviewNo);
	
	/**
	 * 모든 리뷰 반환하기
	 * @return List<Review>
	 */
	List<Review> getAllReviews();	
	
	/**
	 * 내가쓴 리뷰 삭제하기
	 * @param review
	 */
	void deleteMyReview(Review review);
	
}
