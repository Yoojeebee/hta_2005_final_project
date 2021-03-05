package com.yogiyo.pay.web.form;

import java.util.List;

public class CartForm {

	private int amount;
	private int storeNo; // 어디에서 어떻게 받아올것인가?
	private int menuNo;
	List<OptionMenuForm> optionMenuFormList;
	
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public List<OptionMenuForm> getOptionMenuFormList() {
		return optionMenuFormList;
	}
	public void setOptionMenuFormList(List<OptionMenuForm> optionMenuFormList) {
		this.optionMenuFormList = optionMenuFormList;
	}
	@Override
	public String toString() {
		return "CartForm [menuNo=" + menuNo + ", amount=" + amount + ", storeNo=" + storeNo + ", optionMenuFormList="
				+ optionMenuFormList + "]";
	}
	
}
