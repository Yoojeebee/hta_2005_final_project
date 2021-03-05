package com.yogiyo.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.review.dao.ReviewOrderDao;
import com.yogiyo.review.vo.ReviewOrderItem;

@Service
public class ReviewOrderServiceImpl implements ReviewOrderService {

	@Autowired
	ReviewOrderDao orderDao;
	
	/**
	 * userNo로 내가 주문한 내역 조회
	 * @param userNo
	 * @return ReviewOrderItem
	 */
	@Override
	public ReviewOrderItem getOrderInfoByUserNo(String userNo) {
		return orderDao.getOrderInfoByUserNo(userNo);
	}

}
