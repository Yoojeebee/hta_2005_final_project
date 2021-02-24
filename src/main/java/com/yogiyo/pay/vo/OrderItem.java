package com.yogiyo.pay.vo;

public class OrderItem {

	private int no;
	private int amount;
	private int menuNo;
	private int orderNo;
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
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "OrderItem [no=" + no + ", amount=" + amount + ", menuNo=" + menuNo + ", orderNo=" + orderNo + "]";
	}
	
	
}
