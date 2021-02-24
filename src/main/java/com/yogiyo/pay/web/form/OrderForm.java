package com.yogiyo.pay.web.form;

import java.util.List;

import com.yogiyo.pay.dto.CartItemDto;

import lombok.Data;

@Data
public class OrderForm {

	private List<CartItemDto> cartItemDtos;
	private int totalCartPrice;
	private int minPrice;
    private int deliveryTip;
    //-----------여기서부터 form값--------
	private String storeName;
	private String originAddress;
	private String address;
	private String detail;
	private String tel;
	private String message;
	private String payMethod;
	private boolean safeNum;
}
