package com.yogiyo.pay.vo;

import java.util.Date;

@Data
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
