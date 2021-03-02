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
			if(orderForm.getDeliveryTip() > 0) {
				order.setTotalOrderPrice(orderForm.getTotalCartPrice() + orderForm.getDeliveryTip());
			} else {
				order.setTotalOrderPrice(orderForm.getTotalCartPrice());
			}
			int cartItemNo = 0; 
			for (CartItemDto dto : orderForm.getCartItemDtos()) {
				cartItemNo = dto.getNo();
			}
			order.setCartItemNo(cartItemNo);
			order.setUserNo("1"); //loginedUserNo 로 바꿔준다.
			
			// 안심번호를 체크하면, 주문자의 전화번호를 암호화하고 DB에 저장한다.
			if (orderForm.isSafeNum() == true) {
				
				String[] randomArr = new String[2];
				for(int i=0; i < randomArr.length; i++) {
					// 2000~9999까지의 정수 중에서 난수를 추출
					String randomNum = String.valueOf(2000+(int)(Math.random()*7999));
					randomArr[i] = randomNum;
				}
				String safeTel = "070-" + randomArr[0] + "-" + randomArr[1];	// 070-2342-5912(난수추출로 만든 안심번호)
				order.setSafeNum(safeTel);
			}
			
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
