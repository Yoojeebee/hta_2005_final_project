package com.yogiyo.pay.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.pay.dao.CartItemDao;
import com.yogiyo.pay.dao.OptionMenuDao;
import com.yogiyo.pay.dao.PayStoreMenuDao;
import com.yogiyo.pay.dto.CartItemDto;
import com.yogiyo.pay.util.SessionUtils;
import com.yogiyo.pay.vo.CartItem;
import com.yogiyo.pay.vo.StoreMenu;
import com.yogiyo.pay.web.form.CartForm;
import com.yogiyo.pay.web.form.OptionMenuForm;


@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemDao cartItemDao;
	
	@Autowired
	OptionMenuDao optionMenuDao;
	
	@Autowired
	PayStoreMenuDao payStoreMenuDao;
	
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
		int minPrice = -1;
		int deliveryTip = -1;
		String storeName = "";
		String originAddress = "서울시 종로구 봉익동 777";  //(String)SessionUtils.getAttribute("origin");
		List<CartItemDto> cartItemDtoList = cartItemDao.getAllCartItemsByUserNo(userNo);
		System.out.println("cart/items요청시 반환되는 dtoList: "+cartItemDtoList);
		for(CartItemDto dto : cartItemDtoList) {
			totalCartPrice += dto.getPrice();
			minPrice = dto.getStoreMinPrice();
			deliveryTip = dto.getDeliveryTip();
			storeName = dto.getStoreName();
		}
		
		result.put("cartItemDtos", cartItemDtoList);
		result.put("totalCartPrice", totalCartPrice);
		result.put("minPrice", minPrice);
		result.put("deliveryTip", deliveryTip);
		result.put("storeName", storeName);
		result.put("originAddress", originAddress);
	
		System.out.println("cart/items요청시 반환되는 resultMap: " + result);
		return result;
	}
	
	/**
	 * 주문표에 주문할 메뉴를 추가하는 기능
	 * (메뉴이름, 메뉴가격, 메뉴 부가정보, 메뉴옵션이름, 메뉴옵션가격, 수량 , 총주문금액, 최소주문금액이 포함되어있다)
	 * @param cartItem 주문할 메뉴정보 
	 */
	@Override
	public Map<String, Object> insertCartItem(CartForm cartForm) {
		
		Map<String, Object> result = new ConcurrentHashMap<String, Object>();
		
		// controller로 부터 CartForm정보를 받아 CartItem의 틀에 맞게 가공해서
		// Dao의 매개변수로 가공된 CartItem정보를 저장한다.
		CartItem cartItem = new CartItem();
		cartItem.setAmount(cartForm.getAmount());
		cartItem.setUserNo((String)SessionUtils.getAttribute("LOGINED_USER_NO"));
		cartItem.setStoreNo(cartForm.getStoreNo());
		cartItem.setMenuNo(cartForm.getMenuNo());
		
		// CartItem의 optionMenuNames와 cartItemPrice를 set하기위한 작업
		StringBuilder sb = new StringBuilder(); 
		int cartItemPrice = 0;
		StoreMenu storeMenu = payStoreMenuDao.getStoreMenuByMenuNo(cartForm.getMenuNo());
		cartItemPrice += storeMenu.getPrice();
		
		List<OptionMenuForm> omFormList = cartForm.getOptionMenuFormList();
		for(int i=0; i < omFormList.size(); i++) {
			sb.append(omFormList.get(i).getName());
			if(i < omFormList.size() - 1) {
				sb.append(", ");
			}
			cartItemPrice += omFormList.get(i).getPrice();
		}
		String optionMenuNames = sb.toString();
		cartItem.setOptionMenuNames(optionMenuNames);
		cartItem.setPrice(cartItemPrice);
		
		cartItemDao.insertCartItem(cartItem);
		
		return result;
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
		cartItem.setPrice(cartItemDto.getPrice());
		cartItem.setCreatedDate(cartItemDto.getCreatedDate());
		cartItem.setUserNo(cartItemDto.getUserNo());
		cartItem.setStoreNo(cartItemDto.getStoreNo());
		cartItem.setMenuNo(cartItemDto.getStoreMenuNo());
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
