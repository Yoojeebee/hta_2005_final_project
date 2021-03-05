package com.yogiyo.review.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.review.vo.Review;


@Mapper
public interface ReviewDao {

	/**
	 * 조건에 해당하는 리뷰를 클린리뷰 페이지에 보여준다
	 * @param condition
	 * @return List<Review>
	 */
	List<Review> getReviews(Map<String, Object> condition);				
	
	/**
	 * 모든 리뷰를 반환한다
	 * @return List<Review>
	 */
	List<Review> getAllReviews();					
	
	/**
	 * 조건에 맞는 리뷰의 총 개수를 반환한다
	 * @param condition
	 * @return List<Review>
	 */
	List<Review> getTotalCountByCondition(Map<String, Object> condition);	
	
	/**
	 * 조건에 해당하는 리뷰의 개수를 반환한다
	 * @param condition
	 * @return 리뷰의 개수
	 */
	int getReviewCnt(Map<String, Object> condition);
	
	/**
	 * 조건에 해당하는 코멘트 개수를 반환한다
	 * @param condition
	 * @return 코멘트 개수
	 */
	int getCommentCnt(Map<String, Object> condition);
	
	/**
	 * 리뷰를 작성해서 생성한다
	 * @param review
	 */
	void createMyReview(Review review);					
	
	/**
	 * 코멘트를 작성해서 생성한다
	 * @param review
	 */
	void createComment(Review review);					
	
	/**
	 * storeNo에 해당하는 리뷰를 반환한다
	 * @param storeNo
	 * @return Review 
	 */
	Review getReviewByStoreNo(String storeNo);
	
	/**
	 * reviewNo에 해당하는 리뷰를 반환한다
	 * @param reviewNo
	 * @return Review 
	 */
	Review getReviewByReviewNo(int reviewNo);
	
	/**
	 * 리뷰의 총 개수를 반환한다
	 * @return 리뷰의 총 개수
	 */
	int getReviewCount();								
	
	/**
	 * 내가 쓴 리뷰를 삭제한다
	 * @param review
	 */
	void deleteMyReview(Review review);					
	
}
