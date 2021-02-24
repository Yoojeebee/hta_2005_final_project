package com.yogiyo.pay.vo;


public class OptionMenu {

	private int no;
	private String name;
	private int price;
	private int storeOptionGroupNo;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStoreOptionGroupNo() {
		return storeOptionGroupNo;
	}
	public void setStoreOptionGroupNo(int storeOptionGroupNo) {
		this.storeOptionGroupNo = storeOptionGroupNo;
	}
	@Override
	public String toString() {
		return "OptionMenu [no=" + no + ", name=" + name + ", price=" + price + ", StoreOptionGroupNo="
				+ storeOptionGroupNo + "]";
	}
	
	
}
