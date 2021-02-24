package com.yogiyo.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String main(Model model) {
		//String loginedUserNo = (String)session.getAttribute("LOGINED_USER_NO");
		//model.addAttribute(loginedUserNo);
		return "home";
	}
	
}
