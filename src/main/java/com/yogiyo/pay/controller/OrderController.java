package com.yogiyo.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogiyo.pay.dto.OrderItemDto;
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
	public String success(@RequestParam("orderno")int orderNo, Model model) {

		Order order = orderService.getOrderByOrderNo(orderNo);
		List<OrderItemDto> dtoList = orderService.getAllOrderItemDtosByUserNo();
		
		model.addAttribute("order", order);
		model.addAttribute("dto", dtoList.get(0));
		model.addAttribute("dtoList", dtoList);
		
		return "pay/order/success";
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		List<OrderItemDto> orderItemDtoList = orderService.getAllOrderItemDtosByUserNo();
		model.addAttribute("dtoList", orderItemDtoList);
		
		return "pay/order/list";
		
	}
}
