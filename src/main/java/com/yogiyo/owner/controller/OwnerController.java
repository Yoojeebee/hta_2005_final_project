package com.yogiyo.owner.controller;

import com.yogiyo.owner.dao.OwnerDao;
import com.yogiyo.owner.form.OwnerForm;
import com.yogiyo.owner.serviceimpl.OwnerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	OwnerServiceImpl ownerService;
	
	@RequestMapping("/login")
	public String login() {
		return "owner/login";
	}

	@RequestMapping("/joinOwner")
	public String joinOwner() {
		return "owner/joinOwner";
	}

	@PostMapping("/joinForm")
	public String joinForm(OwnerForm ownerForm, Model model) {
		ownerService.insertNewOwner(ownerForm);
		return "redirect:/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam("id") String id, @RequestParam("password") String password) {
		return "redirect:store/home";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/owner/login";
	}
}
