package com.yogiyo.pay.vo;

import lombok.Data;

@Data
public class OrderItem {

	private int no;
	private int amount;
	private int price;
	private int menuNo;
	private int orderNo;
	private String optionMenuNames;
	
}
