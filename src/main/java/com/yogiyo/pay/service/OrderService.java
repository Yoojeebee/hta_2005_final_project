package com.yogiyo.pay.service;

import java.util.List;
import java.util.Map;

import com.yogiyo.pay.dto.OrderItemDto;
import com.yogiyo.pay.vo.Order;
import com.yogiyo.pay.web.form.OrderForm;

public interface OrderService {
	
	/**
	 * 입력받은 주문상세정보 양식을 전달받아 DB에 저장하는 기능
	 * @param orderForm
	 */
	public Map<String, Object> insertOrder(OrderForm orderForm);
	
	/**
	 * 전달된 주문번호로 주문정보를 조회하는 기능
	 * @param orderNo 주문번호
	 * @return Order 주문정보
	 */
	public Order getOrderByOrderNo(int orderNo);
	
	/**
	 * 전달된 사용자번호로 해당 사용자가 주문한 모든 주문정보를 조회하는 기능
	 * @param userNo 사용자번호
	 * @return List<OrderItemDto> 주문정보 목록
	 */
	public List<OrderItemDto> getAllOrderItemDtosByUserNo();
	
	/**
	 * 전달된 주문아이템 번호에 해당하는 주문정보를 조회하는 기능
	 * @param orderItemNo 주문아이템 번호
	 * @return OrderItemDto 주문정보
	 */
	public OrderItemDto getOrderItemDtoByOrderItemNo(int orderItemNo);
	
	/**
	 * 전달된 사용자번호와 주문번호에 해당하는 주문상세정보 목록을 하나의 문자열로 만들어 반환하는 기능
	 * @param userNo
	 * @param orderNo
	 * @return
	 */
	public String getOrderItemDtosToString(String userNo, int orderNo);
	
	/**
	 * 전달받은 사용자번호화 주문번호에 해당하는 주문상세정보 목록을 반환하는 기능
	 * @param userNo 사용자번호
	 * @param orderNo 주문번호
	 * @return 주문상세정보 목록
	 */
	public List<OrderItemDto> getOrderItemDtoListByUserNoAndOrderNo(String userNo, int orderNo);

	/**
	 * 전달받은 주문정보에 해당하는 DB의 주문정보를 업데이트를 하는 기능
	 * @param order
	 */
	public void updateOrder(Order order);
}
