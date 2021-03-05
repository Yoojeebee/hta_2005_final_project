package com.yogiyo.pay.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CartItem {

	private int no;
	private int amount;
	private int price;
	private String optionMenuNames;
	private String userNo;
	private String storeNo;
	private int menuNo;
	private Date createdDate;
	
}
