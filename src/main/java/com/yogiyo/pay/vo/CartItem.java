package com.yogiyo.pay.vo;

import java.util.Date;

public class CartItem {

	private int no;
	private int amount;
	private int price;
	private String optionMenuNames;
	private String userNo;
	private int storeNo;
	private int menuNo;
	private Date createdDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getOptionMenuNames() {
		return optionMenuNames;
	}
	public void setOptionMenuNames(String optionMenuNames) {
		this.optionMenuNames = optionMenuNames;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartItem [no=" + no + ", amount=" + amount + ", createdDate=" + createdDate + ", userNo=" + userNo
				+ ", storeNo=" + storeNo + ", menuNo=" + menuNo + ", optionMenuNames=" + optionMenuNames + ", price="
				+ price + "]";
	}
	
	
}
