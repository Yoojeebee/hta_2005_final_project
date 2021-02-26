package com.yogiyo.pay.vo;

import java.util.Date;


public class PointHistory {

	private int no;
	private String history;
	private Date createdDate;
	private int userNo;
	private int orderNo;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "PointHistory [no=" + no + ", history=" + history + ", createdDate=" + createdDate + ", userNo=" + userNo
				+ ", orderNo=" + orderNo + "]";
	}
	
	
}
