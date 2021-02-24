package com.yogiyo.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.pay.vo.Order;


@Mapper
public interface OrderDao {

	void insertOrder(Order order);
	
}
