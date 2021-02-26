package com.yogiyo.pay.vo;

import java.util.Date;


public class StoreMenu {

	private int no;
	private String name;
	private int price;
	private Date addDate;
	private String thumbnailPath;
	private String detail;
	private int amount;
	private int storeMenuGroupNo;
	
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
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStoreMenuGroupNo() {
		return storeMenuGroupNo;
	}
	public void setStoreMenuGroupNo(int storeMenuGroupNo) {
		this.storeMenuGroupNo = storeMenuGroupNo;
	}
	@Override
	public String toString() {
		return "StoreMenu [no=" + no + ", name=" + name + ", price=" + price + ", addDate=" + addDate
				+ ", thumbnailPath=" + thumbnailPath + ", detail=" + detail + ", amount=" + amount
				+ ", storeMenuGroupNo=" + storeMenuGroupNo + "]";
	}
	
	
	
}
