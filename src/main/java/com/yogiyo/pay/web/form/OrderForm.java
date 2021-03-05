package com.yogiyo.pay.web.form;

import java.util.List;

import com.yogiyo.pay.dto.CartItemDto;

public class OrderForm {

	private List<CartItemDto> cartItemDtos;
	private int totalCartPrice;
	private int minPrice;
    private int deliveryTip;
    //-----------여기서부터 form값--------
	private String storeName;
	private String originAddress;
	private String detail;
	private String tel;
	private String message;
	private String payMethod;
	private boolean safeNum;
	
	public List<CartItemDto> getCartItemDtos() {
		return cartItemDtos;
	}
	public void setCartItemDtos(List<CartItemDto> cartItemDtos) {
		this.cartItemDtos = cartItemDtos;
	}
	public int getTotalCartPrice() {
		return totalCartPrice;
	}
	public void setTotalCartPrice(int totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getDeliveryTip() {
		return deliveryTip;
	}
	public void setDeliveryTip(int deliveryTip) {
		this.deliveryTip = deliveryTip;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getOriginAddress() {
		return originAddress;
	}
	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public boolean isSafeNum() {
		return safeNum;
	}
	public void setSafeNum(boolean safeNum) {
		this.safeNum = safeNum;
	}
	@Override
	public String toString() {
		return "OrderForm [cartItemDtos=" + cartItemDtos + ", totalCartPrice=" + totalCartPrice + ", minPrice="
				+ minPrice + ", deliveryTip=" + deliveryTip + ", storeName=" + storeName + ", originAddress="
				+ originAddress + ", detail=" + detail + ", tel=" + tel + ", message=" + message + ", payMethod="
				+ payMethod + ", safeNum=" + safeNum + "]";
	}
	
	
}
