package com.yogiyo.pay.web.form;

public class OptionMenuForm {

	private int no;
	private String name;
	private int price;
	
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
	@Override
	public String toString() {
		return "OptionMenuForm [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	
}
