package com.yogiyo.pay.vo;


public class Delivery {

	private String storeNo;
	private int areaNo;
	private int deliveryTip;
	
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public int getAreaNo() {
		return areaNo;
	}
	public void setAreaNo(int areaNo) {
		this.areaNo = areaNo;
	}
	public int getDeliveryTip() {
		return deliveryTip;
	}
	public void setDeliveryTip(int deliveryTip) {
		this.deliveryTip = deliveryTip;
	}
	
	@Override
	public String toString() {
		return "Delivery [storeNo=" + storeNo + ", areaNo=" + areaNo + ", deliveryTip=" + deliveryTip + "]";
	}
	
	
	
}
