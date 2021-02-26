package com.yogiyo.pay.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.yogiyo.pay.web.form.OrderForm;

public interface OrderService {

	/**
	 * 입력받은 주문상세정보 양식을 전달받아 DB에 저장하는 기능
	 * @param orderForm
	 */
	public Map<String, Object> insertOrder(OrderForm orderForm);
}
