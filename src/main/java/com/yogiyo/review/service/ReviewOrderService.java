package com.yogiyo.review.service;

import org.springframework.transaction.annotation.Transactional;

import com.yogiyo.review.vo.ReviewOrderItem;

@Transactional
public interface ReviewOrderService {

	/**
	 * userNo로 내가 주문한 내역 조회
	 * @param userNo
	 * @return ReviewOrderItem
	 */ 
	ReviewOrderItem getOrderInfoByUserNo(String userNo);
}
