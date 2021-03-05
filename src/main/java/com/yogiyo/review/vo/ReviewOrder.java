package com.yogiyo.review.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewOrder {

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
	
}
