package com.yogiyo.pay.vo;

import java.util.Date;

import lombok.Data;

@Data
public class StoreMenu {

	private int no;
	private String name;
	private int price;
	private Date addDate;
	private String thumbnail;
	private String detail;
	private int amount;
	
}
