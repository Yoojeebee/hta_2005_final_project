package com.yogiyo.pay.web.form;

import java.util.List;

import lombok.Data;

@Data
public class CartForm {

	private int amount;
	private String storeNo; 
	private int menuNo;
	List<OptionMenuForm> optionMenuFormList;
	
	
}
