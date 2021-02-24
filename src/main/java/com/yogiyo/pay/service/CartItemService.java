package com.yogiyo.pay.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yogiyo.pay.dto.CartItemDto;


@Service
public interface CartItemService {

	/**
	 * 주문표아이템번호로 주문표에 담긴 메뉴의 정보를 조회한다.
	 */
	CartItemDto getCartItemByCartItemNo(int cartItemNo);
	
	/**
	 * 사용자번호로 모든 주문표(장바구니) 정보를 조회하는 기능
	 * @param userNo
	 * @return 모든 주문표(장바구니)정보
	 */
	List<CartItemDto> getAllCartList();
	
	/**
	 * 로그인한 사용자가 주문표에 담은 모든 메뉴들을 반환한다.
	 * @return List<CartItem> 주문표에 담은 모든 메뉴정보들
	 */
	Map<String, Object> getAllCartItems(String userNo);
	
	/**
	 * 주문표에 주문할 메뉴를 추가하는 기능
	 * (메뉴이름, 메뉴가격, 메뉴 부가정보, 메뉴옵션이름, 메뉴옵션가격, 수량 , 총주문금액, 최소주문금액이 포함되어있다)
	 * @param cartItem 주문할 메뉴정보
	 */
	void insertCartItem(CartItemDto cartItemDto);
	
	/**
	 * 주문표 중 하나의 메뉴에 대한 정보를 변경한다.
	 * (주문표에 추가한 메뉴구성의 수량을 변경)
	 * @param cartItem
	 */
	void updateCartItem(CartItemDto cartItemDto);
	
	/**
	 * 주문표 중 하나의 메뉴에 대한 정보를 삭제한다.
	 * @param cartItemNo
	 */
	void deleteCartItems(int cartItemNo);
	
	/**
	 * 주문표 정보 전체를 삭제한다.
	 * @param userNo
	 */
	void deleteAllCartItemsByUserNo(String userNo);
}
