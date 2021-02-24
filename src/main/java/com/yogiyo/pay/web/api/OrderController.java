package com.yogiyo.pay.web.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogiyo.pay.service.OrderService;
import com.yogiyo.pay.web.form.OrderForm;

@CrossOrigin("*")
@RestController("apiOrderController")
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/insert.do")
	public Map<String, Object> insertOrder(@RequestBody OrderForm orderFom) {
		
		Map<String, Object> result = orderService.insertOrder(orderFom);
		
		return result;
	}
	
}
