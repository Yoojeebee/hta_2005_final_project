package com.yogiyo.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.review.dao.ReviewStoreDao;
import com.yogiyo.review.vo.ReviewStore;


@Service
public class ReviewStoreServiceImpl implements ReviewStoreService {

	@Autowired
	ReviewStoreDao storeDao;
	
	/**
	 * storeNo로 가게정보를 반환한다
	 */
	@Override
	public ReviewStore getStoreByNo(String storeNo) {
		ReviewStore store = storeDao.getStoreByNo(storeNo);
		return store;
	}
}
