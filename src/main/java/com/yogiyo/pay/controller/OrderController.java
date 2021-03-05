package com.yogiyo.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogiyo.pay.dto.CartItemDto;
import com.yogiyo.pay.service.CartItemService;
import com.yogiyo.pay.service.OrderService;
import com.yogiyo.pay.vo.Order;

@CrossOrigin("*")
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	CartItemService cartItemService;
	
	@RequestMapping("/form.do")
	public String form() {
		
		return "pay/order/form";
	}
	
	@RequestMapping("/success.do")
	public String success(@RequestParam("orderNo")int orderNo, Model model) {
		
		Order order = orderService.getOrderByOrderNo(orderNo);
		CartItemDto dto = cartItemService.getCartItemByCartItemNo(order.getCartItemNo());
		model.addAttribute("order", order);
		model.addAttribute("dto", dto);
		
		return "pay/order/success";
	}
}
