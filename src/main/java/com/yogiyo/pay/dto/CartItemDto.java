package com.yogiyo.pay.dto;

import java.util.Date;

public class CartItemDto {

	private int no;
	private int amount;
	private Date createdDate;
	private String userNo;
	// insertCart 메서드 실행과정에서 저장된 option_menu의 이름들을 붙여놓은 것(값은 cart_items테이블참조)
	private String optionMenuNames;
	// Store테이블의 컬럼들
	private int storeNo;
	private String storeName;
	private int storeTel;
	private int storeMinPrice;
	// StoreMenu테이블의 컬럼들
	private int storeMenuNo;
	private String storeMenuName;
	private int storeMenuPrice;
	private int storeMenuGroupNo;
	// Delivery테이블의 컬럼들
	private int deliveryTip;
	// 한 주문아이템에 대한 가격총합
	private int	cartItemPrice; 
	
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
	public int getCartItemPrice() {
		return cartItemPrice;
	}
	public void setCartItemPrice(int cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}
	@Override
	public String toString() {
		return "CartItemDto [no=" + no + ", amount=" + amount + ", createdDate=" + createdDate + ", userNo=" + userNo
				+ ", optionMenuNames=" + optionMenuNames + ", storeNo=" + storeNo + ", storeName=" + storeName
				+ ", storeTel=" + storeTel + ", storeMinPrice=" + storeMinPrice + ", storeMenuNo=" + storeMenuNo
				+ ", storeMenuName=" + storeMenuName + ", storeMenuPrice=" + storeMenuPrice + ", storeMenuGroupNo="
				+ storeMenuGroupNo + ", deliveryTip=" + deliveryTip + ", cartItemPrice=" + cartItemPrice + "]";
	}

}
