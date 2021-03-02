package com.yogiyo.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping("/form.do")
	public String form() {
		
		return "pay/order/form";
	}
	
	@RequestMapping("/success.do")
	public String success() {
		return "pay/order/success";
	}
}
