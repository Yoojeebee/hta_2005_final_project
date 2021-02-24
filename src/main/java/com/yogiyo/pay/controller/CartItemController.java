package com.yogiyo.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yogiyo.pay.service.CartItemService;


@Controller
@RequestMapping("/cart")
public class CartItemController {

	@Autowired
	CartItemService cartItemService;
	
	@RequestMapping("/list.do")
	public String list() {
		//Map<String, Object> result = cartItemService.getAllCartItems(userNo);
		//model.addAttribute("result", result);
		//model.addAttribute("userNo", userNo);
		
		return "cart/list";
	}
	
}