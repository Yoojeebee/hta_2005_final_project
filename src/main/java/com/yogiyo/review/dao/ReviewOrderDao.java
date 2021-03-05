package com.yogiyo.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yogiyo.review.vo.ReviewOrderItem;

@Mapper
public interface ReviewOrderDao {

	/**
	 * userNo로 내가 주문한 내역 조회
	 * @param userNo
	 * @return ReviewOrderItem
	 */
	List<ReviewOrderItem> getOrderInfoByUserNo(@Param("userNo") String userNo, @Param("orderNo") int orderNo);
}
