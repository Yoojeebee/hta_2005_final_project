package com.yogiyo.pay.vo;

import java.util.Date;

public class PayStore {

	private int no;
	private String name;
	private String thumbnailPath;
	private int tel;
	private String open;
	private String closed;
	private String address;
	private int minPrice;
	private String status;
	private Date createdDate;
	private String ownerNo;
	
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
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getClosed() {
		return closed;
	}
	public void setClosed(String closed) {
		this.closed = closed;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getOwnerNo() {
		return ownerNo;
	}
	public void setOwnerNo(String ownerNo) {
		this.ownerNo = ownerNo;
	}
	@Override
	public String toString() {
		return "Store [no=" + no + ", name=" + name + ", thumbnailPath=" + thumbnailPath + ", tel=" + tel + ", open="
				+ open + ", closed=" + closed + ", address=" + address + ", minPrice=" + minPrice + ", status=" + status
				+ ", createdDate=" + createdDate + ", ownerNo=" + ownerNo + "]";
	}
	
	
}
