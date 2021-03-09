package com.yogiyo.pay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.pay.dao.CartItemDao;
import com.yogiyo.pay.dao.OrderDao;
import com.yogiyo.pay.dto.CartItemDto;
import com.yogiyo.pay.dto.OrderItemDto;
import com.yogiyo.pay.vo.Order;
import com.yogiyo.pay.vo.OrderItem;
import com.yogiyo.pay.web.form.OrderForm;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CartItemDao cartItemDao;
	
	@Override
	public Map<String, Object> insertOrder(OrderForm orderForm) {
		
		Map<String, Object> result = new ConcurrentHashMap<>();
		try {
			// 세션에서 로그인정보 획득
			String userNo = String.valueOf(((User)SessionUtils.getAttribute("LOGINED_USER")).getNo());
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
			order.setUserNo(userNo);
			
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
			
			// 주문한 메뉴의 종류를 담을 리스트 선언
			 List<String> storeMenuNameList = new ArrayList<>();
			 
			for(CartItemDto dto : orderForm.getCartItemDtos()) {
				storeMenuNameList.add(dto.getStoreMenuName());
			}
			order.setCount(storeMenuNameList.size());
			// Order객체에 입력정보를 담고 insert메소드 호출
			orderDao.insertOrder(order);
			int orderNo = order.getNo();
			
			// DB에 OrderItem을 입력하기 위한 작업
			for(CartItemDto dto : orderForm.getCartItemDtos()) {
				// OrderItem은 한 주문표의 여러 메뉴 중 하나의 메뉴다.
				OrderItem orderItem = new OrderItem();
				orderItem.setAmount(dto.getAmount());
				orderItem.setMenuNo(dto.getStoreMenuNo());
				orderItem.setOrderNo(order.getNo());
				orderItem.setOptionMenuNames(dto.getOptionMenuNames());
				orderItem.setPrice(dto.getPrice());
				
				orderDao.insertOrderItem(orderItem);
			}
			result.put("orderno", orderNo);
			// 예외확인을 위해 성공했으면 true를,
			result.put("success", true);
			
			// 모든 주문이 성공적으로 끝나면 장바구니의 모든 아이템들을 삭제한다.
			cartItemDao.deleteAllCartItemsByUserNo(userNo);
		} catch (Exception e) {
			e.printStackTrace();
			// 실패했으면 success에 false를 map에 담는다.
			result.put("success", false);
		}
		
		return result;
	}
	
	@Override
	public Order getOrderByOrderNo(int orderNo) {
		return orderDao.getOrderInfoByOrderNo(orderNo);
	}
	
	@Override
	public List<OrderItemDto> getAllOrderItemDtosByUserNo() {
		return orderDao.getAllOrderItemDtosByUserNo(String.valueOf(((User)SessionUtils.getAttribute("LOGINED_USER")).getNo()));
	}
	 
	 @Override
	 public OrderItemDto getOrderItemDtoByOrderItemNo(int orderItemNo) {
		 return orderDao.getOrderItemDtoByOrderItemNo(orderItemNo);
	 }
	 
	 @Override
	 public String getOrderItemDtosToString(String userNo, int orderNo) {
		 System.out.println("userno = " + userNo + "/ orderNo = " + orderNo);
		 List<OrderItemDto> orderItemDtoList = orderDao.getOrderItemDtosByUserNoAndOrderNo(userNo, orderNo);
		 // 위에서 조회한 dtoList에서 필요한 정보를 하나의 문자열로 만들기 위한 StringBuilder선언
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i < orderItemDtoList.size(); i++) {
			 OrderItemDto dto = orderItemDtoList.get(i);
			 sb.append(dto.getStoreMenuName()+": ");
			 sb.append("("+dto.getOrderItemOptionMenuNames()+")x");
			 sb.append(dto.getOrderItemAmount()+"개");
			 if(i < orderItemDtoList.size() - 1) {
					sb.append("/ ");
				}
		 }
		 
		 return sb.toString();
	 }
	 
	 @Override
	 public List<OrderItemDto> getOrderItemDtoListByUserNoAndOrderNo(String userNo, int orderNo) {

		 return orderDao.getOrderItemDtosByUserNoAndOrderNo(userNo, orderNo);
	 }

	 @Override
	 public void updateOrder(Order order) {
		orderDao.updateOrder(order); 
	 }
}