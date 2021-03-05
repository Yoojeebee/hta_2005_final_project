package com.yogiyo.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.pay.vo.Order;
import com.yogiyo.pay.vo.OrderItem;


@Mapper
public interface OrderDao {

	/**
	 * 전달된 주문정보를 DB에 저장하는 기능
	 * @param order
	 */
	void insertOrder(Order order);
	
	/**
	 * 전달된 주문아이템정보로 DB에 저장하는 기능
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);
	
	/**
	 * 전달된 주문표번호로 주문번호를 조회하는기능
	 * @param cartItemNo
	 * @return 주문번호
	 */
	int getOrderNoByCartNo(int cartItemNo);
	
	/**
	 * 전달된 주문번호로 주문정보를 조회하는 기능
	 * @param orderNo
	 * @return
	 */
	Order getOrderInfoByOrderNo(int orderNo);
	
}
