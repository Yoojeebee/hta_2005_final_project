package com.yogiyo.review.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.review.vo.ReviewStore;

@Mapper
public interface ReviewStoreDao {

	void updateStoreScore(ReviewStore store);
	void updateStoreReviewAcc(ReviewStore store);
	void updateStoreOwnerAcc(ReviewStore store);
	ReviewStore getStoreByNo(String storeNo);
	
}
