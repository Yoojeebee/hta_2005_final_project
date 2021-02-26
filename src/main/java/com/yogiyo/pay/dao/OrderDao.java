package com.yogiyo.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.pay.vo.Order;
import com.yogiyo.pay.vo.OrderItem;


@Mapper
public interface OrderDao {

	void insertOrder(Order order);
	
	void insertOrderItem(OrderItem orderItem);
	
}
