package com.yogiyo.pay.vo;


public class StoreOrder {

	private int storeNo;
	private int orderNo;
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "StoreOrder [storeNo=" + storeNo + ", orderNo=" + orderNo + "]";
	}
	
	
}
