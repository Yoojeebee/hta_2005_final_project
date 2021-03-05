package com.yogiyo.pay.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CartItemDto {
	
	// Cart_item테이블에 대한 기존정보
	private int no;
	private int amount;
	private int	price; 
	private String optionMenuNames;
	private Date createdDate;
	
	// User테이블의 컬럼들
	private String userNo;
	
	// Store테이블의 컬럼들
	private String storeNo;
	private String storeName;
	private int storeTel;
	private int storeMinPrice;
	
	// StoreMenu테이블의 컬럼들
	private int storeMenuNo;
	private String storeMenuName;
	private int storeMenuPrice;
	private int storeMenuGroupNo;
	
	// Delivery테이블의 컬럼들
	private int deliveryTip;
	
}
