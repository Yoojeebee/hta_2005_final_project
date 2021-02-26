package com.yogiyo.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartItemController {

	@RequestMapping("/list.do")
	public String list() {
		
		return "pay/cart/list";
	}
	
}