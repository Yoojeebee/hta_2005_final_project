package com.yogiyo.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yogiyo.pay.dto.OrderItemDto;
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
	 * 전달된 주문번호로 주문정보를 조회하는 기능
	 * @param orderNo
	 * @return 사용자정보
	 */
	Order getOrderInfoByOrderNo(int orderNo);
	
	/**
	 * 전달된 사용자번호로 해당 사용자의 모든 주문정보를 조회하는 기능
	 * @param userNo
	 * @return List<OrderItemDto>
	 */
	List<OrderItemDto> getAllOrderItemDtosByUserNo(String userNo);
	
	/**
	 * 전달받은 주문아이템 번호에 해당하는 주문아이템정보를 조회한다.
	 * @param orderItemNo
	 * @return
	 */
	OrderItemDto getOrderItemDtoByOrderItemNo(int orderItemNo);
	
	/**
	 * 전달받은 사용자번호와 주문번호에 해당하는 주문상세정보목록을 조회하는 기능
	 * @param userNo
	 * @param orderNo
	 * @return
	 */
	List<OrderItemDto> getOrderItemDtosByUserNoAndOrderNo(@Param("userNo")String userNo, @Param("orderNo")int orderNo);
}
