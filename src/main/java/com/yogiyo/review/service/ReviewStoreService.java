package com.yogiyo.review.service;

import org.springframework.transaction.annotation.Transactional;

import com.yogiyo.review.vo.ReviewStore;


@Transactional
public interface ReviewStoreService {

	/**
	 * storeNo로 가게정보를 조회한다
	 * @param storeNo
	 * @return ReviewStore
	 */
	ReviewStore getStoreByNo(String storeNo);
}
