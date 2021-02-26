package com.yogiyo.pay.vo;


public class OptionMenu {

	private int no;
	private String name;
	private int price;
	private int groupNo;
	
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
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	@Override
	public String toString() {
		return "OptionMenu [no=" + no + ", name=" + name + ", price=" + price + ", groupNo=" + groupNo + "]";
	}
	
	
}
