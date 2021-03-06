package com.yogiyo.pay.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderItemDto {

	// Order
	private int no;
	private String recipientTel;
	private String recipientAddress;
	private String recipientAddressDeatail;
	private String message;
	private String status;
	private Date createdDate;
	private String userNo;
	private String paymentMethod;
	private int totalOrderPrice;
	private String safeNum;
	private int count;
	
	// OrderItem
	private int orderItemNo;
	private int orderItemAmount;
	private String orderItemOptionMenuNames;
	private int orderItemPrice;

	// Store
	private String storeNo;
	private String storeName;
	private String storeTel;
	private int storeMinPrice;
	
	// Delivery
	private int deliveryTip;
	
	// StoreMenu
	private int storeMenuNo;
	private String storeMenuName;
	private int storeMenuPrice;
	
}
