package com.yogiyo.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yogiyo.search.service.CategoryService;
import com.yogiyo.search.vo.Category;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	// yogiyo/main.do 요청에 대한 요청핸들러 메소드
    @RequestMapping("/home.do")
    public String home(Model model) {
    	
    	// home 화면에 표시될 데이터를 조회하기
    	List<Category> categories = categoryService.getAllCategories();
    	model.addAttribute("categories", categories);
    	return "home";
    }

}