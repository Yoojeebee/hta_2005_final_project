package com.yogiyo.pay.web.form;

import java.util.List;

import lombok.Data;

@Data
public class CartForm {

	private int amount;
	private String storeNo; // 어디에서 어떻게 받아올것인가?
	private int menuNo;
	List<OptionMenuForm> optionMenuFormList;
	
}
