package com.yogiyo.pay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogiyo.pay.dao.CartItemDao;
import com.yogiyo.pay.dto.CartItemDto;
import com.yogiyo.pay.util.SessionUtils;
import com.yogiyo.pay.vo.CartItem;
import com.yogiyo.pay.vo.OptionMenu;


@Repository
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemDao cartItemDao;
	
	/**
	 * 주문표아이템번호로 주문표에 담긴 메뉴의 정보를 조회한다.
	 */
	@Override
	public CartItemDto getCartItemByCartItemNo(int cartItemNo) {
		return cartItemDao.getCartItemByCartItemNo(cartItemNo);
	}
	
	@Override
	public List<CartItemDto> getAllCartList() {
		String userNo = (String)SessionUtils.getAttribute("LOGINED_USER_NO");
		List<CartItemDto> allCartList = cartItemDao.getAllCartItemsByUserNo(userNo);
		
		return allCartList;
	}
	/**
	 * 로그인한 사용자가 주문표에 담은 모든 메뉴들을 반환한다.
	 * @return List<CartItem> 주문표에 담은 모든 메뉴정보들
	 */
	@Override
	public Map<String, Object> getAllCartItems(String userNo) {
		Map<String, Object> result = new HashMap<>();
		
		/*
		 * String loginedUserNo = (String)SessionUtils.getAttribute("LOGINED_USER_NO");
		 * if(userNo != loginedUserNo) { throw new
		 * NotFoundException("["+userNo+"]에 해당하는 주문표정보를 불러올 수 없습니다."); }
		 */
		
		// map에 담아 반환할 변수들
		int totalCartPrice = 0;
		int minPrice = 0;
		int deliveryTip = 0;
		String storeName = "";
		String originAddress = (String)SessionUtils.getAttribute("origin");
		List<CartItemDto> cartItemDtoList = cartItemDao.getAllCartItemsByUserNo(userNo);
		List<Map<String, Object>> dtoAndOptionSbList = new ArrayList<>();
		
		for(CartItemDto dto : cartItemDtoList) {
			//dto 1개, 옵션메뉴 sb 한개를 담을 map
			Map<String, Object> dtoAndOptionSb = new ConcurrentHashMap<>();
			
			StringBuilder sb = new StringBuilder();
			
			//옵션메뉴이름을 연결하기 위해 필요한 List
			List<OptionMenu> opList = dto.getOptionMenuList();
			for(int i=0; i < opList.size(); i++) {
				totalCartPrice += opList.get(i).getPrice();
				
				sb.append(opList.get(i).getName());
				if(i < opList.size() - 1) {
					sb.append(", ");
				}
			} 
			//dto 한개당 실행되야하는 코드들(dto 한개 담기, 계산)
			totalCartPrice += dto.getStoreMenu().getPrice();
			minPrice = dto.getStore().getMinPrice();
			deliveryTip = dto.getDelivery().getDeliveryTip();
			storeName = dto.getStore().getName();
			
			dtoAndOptionSb.put("cartItemDto", dto);
			dtoAndOptionSb.put("optionMenuNames",sb);
			
			dtoAndOptionSbList.add(dtoAndOptionSb);
		}
		
		result.put("dtoAndOptionSbList", dtoAndOptionSbList);
		result.put("cartItemDtos", cartItemDtoList);
		result.put("totalCartPrice", totalCartPrice);
		result.put("minPrice", minPrice);
		result.put("deliveryTip", deliveryTip);
		result.put("userno", userNo);
		result.put("storeName", storeName);
		result.put("originAddress", originAddress);
		
		return result;
	}
	
	/**
	 * 주문표에 주문할 메뉴를 추가하는 기능
	 * (메뉴이름, 메뉴가격, 메뉴 부가정보, 메뉴옵션이름, 메뉴옵션가격, 수량 , 총주문금액, 최소주문금액이 포함되어있다)
	 * @param cartItem 주문할 메뉴정보 
	 */
	@Override
	public void insertCartItem(CartItemDto cartItemDto) {
		// ServiceImpl단에서 CartItemDto의 정보를 받아 CartItem의 틀에 맞게 가공해서
		// Dao의 매개변수로 가공된 CartItem정보를 저장한다.
		CartItem cartItem = new CartItem();
		cartItem.setNo(cartItemDto.getNo());
		cartItem.setAmount(cartItemDto.getAmount());
		cartItem.setCreatedDate(cartItemDto.getCreatedDate());
		cartItem.setUserNo(cartItemDto.getUserNo());
		cartItem.setStoreNo(cartItemDto.getStore().getNo());
		cartItem.setMenuNo(cartItemDto.getStoreMenu().getNo());
		List<OptionMenu> opmenuList = cartItemDto.getOptionMenuList();
		int optionMenuNo = 0;
		for(OptionMenu om : opmenuList) {
			// opmenuList의 마지막번째 옵션메뉴번호가 저장된다.
			optionMenuNo = om.getNo();
		}
		cartItem.setOptionMenuNo(optionMenuNo);
		cartItem.setOptionMenuNames(cartItemDto.getOptionMenuNames());
		
		cartItemDao.insertCartItem(cartItem);
	}
	
	/**
	 * 주문표 중 하나의 메뉴에 대한 정보를 변경한다.
	 * (주문표에 추가한 메뉴구성의 수량을 변경)
	 * @param cartItem
	 */
	@Override
	public void updateCartItem(CartItemDto cartItemDto) {
		// ServiceImpl단에서 CartItemDto의 정보를 받아 CartItem의 틀에 맞게 가공해서
		// Dao의 매개변수로 가공된 CartItem정보를 저장한다.
		CartItem cartItem = new CartItem();
		cartItem.setNo(cartItemDto.getNo());
		cartItem.setAmount(cartItemDto.getAmount());
		cartItem.setCreatedDate(cartItemDto.getCreatedDate());
		cartItem.setUserNo(cartItemDto.getUserNo());
		cartItem.setStoreNo(cartItemDto.getStore().getNo());
		cartItem.setMenuNo(cartItemDto.getStoreMenu().getNo());
		List<OptionMenu> opmenuList = cartItemDto.getOptionMenuList();
		int optionMenuNo = 0;
		for(OptionMenu om : opmenuList) {
			// opmenuList의 마지막번째 옵션메뉴번호가 저장된다.
			optionMenuNo = om.getNo();
		}
		cartItem.setOptionMenuNo(optionMenuNo);
		cartItem.setOptionMenuNames(cartItemDto.getOptionMenuNames());
		
		cartItemDao.updateCartItem(cartItem);
	}
	
	/**
	 * 전달받은 주문표번호에 해당하는 메뉴에 대한 정보를 주문표에서 삭제한다.
	 * @param cartItemNo
	 */
	@Override
	public void deleteCartItems(int cartItemNo) {
		cartItemDao.deleteCartItem(cartItemNo);
	}
	
	public void deleteAllCartItemsByUserNo(String userNo) {
		cartItemDao.deleteAllCartItemsByUserNo(userNo);
	}
		
}
