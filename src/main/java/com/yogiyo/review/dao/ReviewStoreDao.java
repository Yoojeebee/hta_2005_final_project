package com.yogiyo.review.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.review.vo.ReviewStore;

@Mapper
public interface ReviewStoreDao {

	/**
	 * 리뷰작성시, 가게의 점수를 update한다
	 * @param store
	 */
	void updateStoreScore(ReviewStore store);
	
	/**
	 * 리뷰작성시, 가게의 리뷰 개수를 update한다
	 * @param store
	 */
	void updateStoreReviewAcc(ReviewStore store);
	
	/**
	 * 사장이 코멘트 작성시, 가게의 코멘트 개수를 update한다
	 * @param store
	 */
	void updateStoreOwnerAcc(ReviewStore store);
	
	/**
	 * storeNo로 가게를 조회한다
	 * @param storeNo
	 * @return ReviewStore
	 */
	ReviewStore getStoreByNo(String storeNo);
	
}
