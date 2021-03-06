package com.yogiyo.pay.dto;

import java.util.Date;

public class CartItemDto {
	
	// Cart_item테이블에 대한 기존정보
	private int no;
	private int amount;
	private int	price; 
	private String optionMenuNames;
	private Date createdDate;
	
	// User테이블의 컬럼들
	private String userNo;
	
	// Store테이블의 컬럼들
	private int storeNo;
	private String storeName;
	private String storeTel;
	private int storeMinPrice;
	
	// StoreMenu테이블의 컬럼들
	private int storeMenuNo;
	private String storeMenuName;
	private int storeMenuPrice;
	private int storeMenuGroupNo;
	
	// Delivery테이블의 컬럼들
	private int deliveryTip;
	
	
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
	public String getOptionMenuNames() {
		return optionMenuNames;
	}
	public void setOptionMenuNames(String optionMenuNames) {
		this.optionMenuNames = optionMenuNames;
	}
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(int storeTel) {
		this.storeTel = storeTel;
	}
	public int getStoreMinPrice() {
		return storeMinPrice;
	}
	public void setStoreMinPrice(int storeMinPrice) {
		this.storeMinPrice = storeMinPrice;
	}
	public int getStoreMenuNo() {
		return storeMenuNo;
	}
	public void setStoreMenuNo(int storeMenuNo) {
		this.storeMenuNo = storeMenuNo;
	}
	public String getStoreMenuName() {
		return storeMenuName;
	}
	public void setStoreMenuName(String storeMenuName) {
		this.storeMenuName = storeMenuName;
	}
	public int getStoreMenuPrice() {
		return storeMenuPrice;
	}
	public void setStoreMenuPrice(int storeMenuPrice) {
		this.storeMenuPrice = storeMenuPrice;
	}
	public int getStoreMenuGroupNo() {
		return storeMenuGroupNo;
	}
	public void setStoreMenuGroupNo(int storeMenuGroupNo) {
		this.storeMenuGroupNo = storeMenuGroupNo;
	}
	public int getDeliveryTip() {
		return deliveryTip;
	}
	public void setDeliveryTip(int deliveryTip) {
		this.deliveryTip = deliveryTip;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartItemDto [no=" + no + ", amount=" + amount + ", price=" + price + ", createdDate=" + createdDate
				+ ", userNo=" + userNo + ", optionMenuNames=" + optionMenuNames + ", storeNo=" + storeNo
				+ ", storeName=" + storeName + ", storeTel=" + storeTel + ", storeMinPrice=" + storeMinPrice
				+ ", storeMenuNo=" + storeMenuNo + ", storeMenuName=" + storeMenuName + ", storeMenuPrice="
				+ storeMenuPrice + ", storeMenuGroupNo=" + storeMenuGroupNo + ", deliveryTip=" + deliveryTip + "]";
	}
	
	
}
