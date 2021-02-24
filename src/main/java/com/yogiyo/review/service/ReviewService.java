package com.yogiyo.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.yogiyo.review.vo.Review;


@Transactional
public interface ReviewService {

	//reviewDAO.saveDivisionData 에서 처리한 쿼리문이 정상적으로 완료가 되고, 
	//reviewDAO.saveextensionTarget 에서 처리 도중 에러가 났을 때
	//reviewDAO.saveDivisionData 에서 처리한 쿼리를 자동 rollback 해주기 위해 사용된다.

	Map<String, Object> getReviewByCondition(Map<String, Object> condition);	// 조건(특정 상점)에 해당하는 리뷰를 반환한다
	void createMyReview(Review review);					// 리뷰 작성하기
	void createComment(Review review);
	Review getReviewByStoreNo(String storeNo);
	Review getReviewByReviewNo(int reviewNo);
	List<Review> getAllReviews();	
}
