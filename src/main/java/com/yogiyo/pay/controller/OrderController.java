package com.yogiyo.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogiyo.pay.dto.OrderItemDto;
import com.yogiyo.pay.service.CartItemService;
import com.yogiyo.pay.service.OrderService;
import com.yogiyo.pay.vo.Order;
import com.yogiyo.pay.web.form.CartForm;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;

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
	
	@RequestMapping("/detail.do")
	public String detail(@RequestParam("orderno")int orderNo, Model model) {

		// detail.do 하단의 주문상품목록 표현을 위한 List객체를 model에 저장
		String userNo = String.valueOf(((User)SessionUtils.getAttribute("LOGINED_USER")).getNo());
		List<OrderItemDto> orderItemDtoList = orderService.getOrderItemDtoListByUserNoAndOrderNo(userNo, orderNo);
		model.addAttribute("dtoList", orderItemDtoList);
		// detail.do 상단의 주문정보 표현을 위한 order객체를 model에 저장
		model.addAttribute("order", orderService.getOrderByOrderNo(orderNo));	
		// detail.do 상단의 주문정보 중 주문자 표현을 위한 userName을 model에 저장
		model.addAttribute("userName",((User)SessionUtils.getAttribute("LOGINED_USER")).getName());
		OrderItemDto dto = orderItemDtoList.get(0);
		model.addAttribute("dto", dto);

		return "pay/order/detail";
	}
	
	@PostMapping("/insert.do")
	public String insert(CartForm cartForm) {
		
		System.out.println(cartForm.toString());
		
		return "redirect:/home.do";
	}
	
}
