package com.yogiyo.review.service;

import org.springframework.transaction.annotation.Transactional;

import com.yogiyo.review.vo.ReviewStore;


@Transactional
public interface ReviewStoreService {

	ReviewStore getStoreByNo(String storeNo);
}
