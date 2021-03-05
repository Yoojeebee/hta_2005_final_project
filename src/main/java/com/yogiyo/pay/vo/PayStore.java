package com.yogiyo.pay.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PayStore {

	private String no;
	private String name;
	private String thumbnail;
	private String tel;
	private String open;
	private String closed;
	private String address;
	private int minPrice;
	private String closeStatus;
	private String status;
	private Date createdDate;
	private String paymentOffline;
	private String paymentCard;
	private int avg;
	private int taste;
	private int quan;
	private int del;
	private int reviewAcc;
	private int ownerCommentAcc;
	private String ownerNo;
	
}