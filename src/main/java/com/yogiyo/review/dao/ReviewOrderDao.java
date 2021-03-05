package com.yogiyo.review.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.review.vo.ReviewOrderItem;

@Mapper
public interface ReviewOrderDao {

	/**
	 * userNo로 내가 주문한 내역 조회
	 * @param userNo
	 * @return ReviewOrderItem
	 */
	ReviewOrderItem getOrderInfoByUserNo(String userNo);
}
