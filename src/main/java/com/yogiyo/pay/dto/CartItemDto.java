package com.yogiyo.pay.dto;

import java.util.Date;
import java.util.List;

import com.yogiyo.pay.vo.Delivery;
import com.yogiyo.pay.vo.OptionMenu;
import com.yogiyo.pay.vo.Store;
import com.yogiyo.pay.vo.StoreMenu;

public class CartItemDto {

	private int no;
	private int amount;
	private Date createdDate;
	private String userNo;
	private Store store;
	private StoreMenu storeMenu;
	private List<OptionMenu> optionMenuList;
	private Delivery delivery;
	private String optionMenuNames;
	private int	cartItemPrice;
	
	public String getOptionMenuNames() {
		return optionMenuNames;
	}
	public void setOptionMenuNames(String optionMenuNames) {
		this.optionMenuNames = optionMenuNames;
	}
	public int getCartItemPrice() {
		return cartItemPrice;
	}
	public void setCartItemPrice(int cartItemPrice) {
		// cartItemPrice = 메인메뉴 가격
		this.cartItemPrice = this.storeMenu.getPrice();
		// cartItemPrice = 메인메뉴 가격 + 옵션메뉴'들' 가격
		for(int i=0; i < this.optionMenuList.size(); i++) {
			this.cartItemPrice += this.optionMenuList.get(i).getPrice();
		}
		// cartItemPrice = (메인메뉴 가격 + 옵션메뉴'들' 가격) * 주문아이템 수량
		this.cartItemPrice = this.cartItemPrice*this.amount;
	}
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
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public StoreMenu getStoreMenu() {
		return storeMenu;
	}
	public void setStoreMenu(StoreMenu storeMenu) {
		this.storeMenu = storeMenu;
	}
	public List<OptionMenu> getOptionMenuList() {
		return optionMenuList;
	}
	public void setOptionMenuList(List<OptionMenu> optionMenuList) {
		this.optionMenuList = optionMenuList;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	@Override
	public String toString() {
		return "CartItemDto [no=" + no + ", amount=" + amount + ", createdDate=" + createdDate + ", userNo=" + userNo
				+ ", store=" + store + ", storeMenu=" + storeMenu + ", optionMenuList=" + optionMenuList + ", delivery="
				+ delivery + "]";
	}
	
	
}
