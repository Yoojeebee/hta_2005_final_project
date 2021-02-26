package com.yogiyo.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.pay.dto.CartItemDto;
import com.yogiyo.pay.vo.CartItem;


@Mapper
public interface CartItemDao {

	/**
	 * 사용자번호에 해당하는 주문표(장바구니)의 아이템의 갯수를 반환
	 * @param userNo
	 * @return 주문표 아이템 갯수
	 */
	int getCountCartItems(String userNo);
	
	/**
	 * 주문표아이템번호로 주문표에 담긴 메뉴의 정보를 조회한다.
	 */
	CartItemDto getCartItemByCartItemNo(int cartItemNo);
	
	/**
	 * 로그인한 사용자가 주문표에 담은 모든 메뉴들을 반환한다.
	 * @return 주문표에 담은 모든 메뉴정보들
	 */
	List<CartItemDto> getAllCartItemsByUserNo(String userNo);
	
	/**
	 * 주문표에 주문할 메뉴를 추가하는 기능
	 * (메뉴이름, 메뉴가격, 메뉴 부가정보, 메뉴옵션이름, 메뉴옵션가격, 수량 , 총주문금액, 최소주문금액이 포함되어있다)
	 * @param cartItem 주문할 메뉴정보
	 */
	void insertCartItem(CartItem cartItem);
	
	/**
	 * 주문표 중 하나의 메뉴에 대한 정보를 변경한다.
	 * (주문표에 추가한 메뉴구성의 수량을 변경)
	 * @param cartItem
	 */
	void updateCartItem(CartItem cartItem);
	
	/**
	 * 주문표 중 하나의 메뉴에 대한 정보를 삭제한다.
	 * @param cartItemNo
	 */
	void deleteCartItem(int cartItemNo);
	
	/**
	 * 주문표 전체의 정보를 삭제한다.
	 * @param userNo
	 */
	void deleteAllCartItemsByUserNo(String userNo);
}
