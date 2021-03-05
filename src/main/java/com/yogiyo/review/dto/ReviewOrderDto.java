package com.yogiyo.review.dto;

import lombok.Data;

@Data
public class ReviewOrderDto {

	   // Order
	   private int no;
	   private String userNo;
	   
	   // OrderItem
	   private int orderItemNo;
	   private int orderItemAmount;
	   private String orderItemOptionMenuNames;
	   private int orderItemPrice;
	
	   // Store
	   private int storeNo;
	   private String storeName;
	   
	   // StoreMenu
	   private int storeMenuNo;
	   private String storeMenuName;
	   private int storeMenuPrice;

}
