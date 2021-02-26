package com.yogiyo.pay.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.pay.dao.OrderDao;
import com.yogiyo.pay.dto.CartItemDto;
import com.yogiyo.pay.util.SessionUtils;
import com.yogiyo.pay.vo.Order;
import com.yogiyo.pay.vo.OrderItem;
import com.yogiyo.pay.web.form.OrderForm;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Override
	public Map<String, Object> insertOrder(OrderForm orderForm) {
		
		Map<String, Object> result = new ConcurrentHashMap<>();
		try {
			// 세션에서 로그인정보 획득
			String loginedUserNo = (String)SessionUtils.getAttribute("LOGINED_USER_NO");
			// DB에 입력할 Order객체 생성
			Order order = new Order();
			// 빈 Order객체에 OrderForm에서 추출한 정보를 입력
			order.setRecipientAddress(orderForm.getOriginAddress());
			order.setRecipientAddressDetail(orderForm.getDetail());
			order.setRecipientTel(orderForm.getTel());
			order.setMessage(orderForm.getMessage());
			order.setPaymentMethod(orderForm.getPayMethod());
			order.setTotalOrderPrice(orderForm.getTotalCartPrice());
			int cartItemNo = 0; 
			for (CartItemDto dto : orderForm.getCartItemDtos()) {
				cartItemNo = dto.getNo();
			}
			order.setCartItemNo(cartItemNo);
			order.setUserNo("1"); //loginedUserNo 로 바꿔준다.
			// Order객체에 입력정보를 담고 insert메소드 호출
			orderDao.insertOrder(order);

			// DB에 OrderItem을 입력하기 위한 작업
			for(CartItemDto dto : orderForm.getCartItemDtos()) {
				// OrderItem은 한 주문표의 여러 메뉴 중 하나의 메뉴다.
				OrderItem orderItem = new OrderItem();
				orderItem.setAmount(dto.getAmount());
				orderItem.setMenuNo(dto.getStoreMenuNo());
				orderItem.setOrderNo(order.getNo());
				
				orderDao.insertOrderItem(orderItem);
			}
			
			// 예외확인을 위해 성공했으면 true를,
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			// 실패했으면 success에 false를 map에 담는다.
			result.put("success", false);
		}
		
		return result;
	}
}
