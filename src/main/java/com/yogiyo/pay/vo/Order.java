package com.yogiyo.pay.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {

	private int no;
	private String recipientAddress;
	private String recipientAddressDetail;
	private String recipientTel;
	private String safeNum;
	private String message;
	private String status;
	private String paymentMethod;
	private int totalOrderPrice;
	private String userNo;
	private int cartItemNo;
	private Date createdDate;
	private int count;
	private int reviewNo;
	
}
