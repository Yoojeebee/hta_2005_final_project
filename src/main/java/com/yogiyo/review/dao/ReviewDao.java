package com.yogiyo.review.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.review.vo.Review;


@Mapper
public interface ReviewDao {

	
	List<Review> getReviews(Map<String, Object> condition);					// 리뷰 보여주기(메인)
	List<Review> getAllReviews();					// 모든 리뷰 보여주기(메인)
	List<Review> getTotalCountByCondition(Map<String, Object> condition);	// 리뷰의 개수를 반환한다
	int getReviewCnt(Map<String, Object> condition);
	int getCommentCnt(Map<String, Object> condition);
	
	void createMyReview(Review review);					// 리뷰 작성하기
	void createComment(Review review);					// 코멘트 작성하기
	Review getReviewByStoreNo(String storeNo);
	Review getReviewByReviewNo(int reviewNo);
	int getReviewCount();								// 리뷰의 총 개수를 반환한다
	void deleteMyReview(Review review);					// 내가 쓴 리뷰 삭제하기
}
