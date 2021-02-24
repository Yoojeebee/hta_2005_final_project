package com.yogiyo.pay.vo;

import java.util.Date;


public class Order {

	private int no;
	private String recipientTel;
	private String recipientAddress;
	private String recipientAddressDetail;
	private String message;
	private String status;
	private String paymentMethod;
	private int totalOrderPrice;
	private String userNo;
	private int cartItemNo;
	private Date createdDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRecipientTel() {
		return recipientTel;
	}
	public void setRecipientTel(String recipientTel) {
		this.recipientTel = recipientTel;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getRecipientAddressDetail() {
		return recipientAddressDetail;
	}
	public void setRecipientAddressDetail(String recipientAddressDetail) {
		this.recipientAddressDetail = recipientAddressDetail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getTotalOrderPrice() {
		return totalOrderPrice;
	}
	public void setTotalOrderPrice(int totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public int getCartItemNo() {
		return cartItemNo;
	}
	public void setCartItemNo(int cartItemNo) {
		this.cartItemNo = cartItemNo;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Order [no=" + no + ", recipientTel=" + recipientTel + ", recipientAddress=" + recipientAddress
				+ ", recipientAddressDetail=" + recipientAddressDetail + ", message=" + message + ", status=" + status
				+ ", paymentMethod=" + paymentMethod + ", totalOrderPrice=" + totalOrderPrice + ", userNo=" + userNo
				+ ", cartItemNo=" + cartItemNo + ", createdDate=" + createdDate + "]";
	}
	
	
	
}
