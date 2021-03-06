package com.yogiyo.search.controller;

import java.io.IOException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogiyo.search.exception.DuplicatedUserIdException;
import com.yogiyo.search.exception.PasswordMismatchException;
import com.yogiyo.search.exception.UserNotFoundException;
import com.yogiyo.search.form.UserForm;
import com.yogiyo.search.service.StoreService;
import com.yogiyo.search.service.UserService;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;
import com.yogiyo.util.StringUtils;


@Controller
public class UserController {

	@Autowired
	StoreService storeService;

	@Autowired
	UserService userService;

	// yogiyo/form.do 요청에 대한 요청핸들러 메소드
	@RequestMapping("/form.do")
	public String form() {
		return "form";   //         /WEB-INF/views/form.jsp로 내부이동
	}

	// yogiyo/loginform.do 요청에 대한 요청핸들러 메소드
	@RequestMapping("/loginform.do")
	public String loginform() {
		return "loginform";   //      /WEB-INF/views/loginform.jsp로 내부이동
	}
	
	// yogiyo/login.do 요청에 대한 요청핸들러 메소드
	@RequestMapping("/login.do")
	public String login(@RequestParam("id") String userId, @RequestParam("password") String password) {
		// id=사용자아이디&password=비밀번호가 요청파라미터로 전달된다.
		if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
			return "redirect:loginform.do?error=empty";   // id, password값이 비어있으면 로그인폼을 요청하는 URL을 응답으로 보낸다.
		}
		try {
			User user = userService.getLoginedUserInfo(userId, password);
			// 세션에 로그인된 사용자정보를 저장한다.
			SessionUtils.setAttribute("LOGINED_USER", user);

		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return "redirect:loginform.do?error=notfound";
		} catch (PasswordMismatchException e) {
			e.printStackTrace();
			return "redirect:loginform.do?error=mismatch";
		}
		return "redirect:home.do";
	}
	
	// yogiyo/logout.do 요청에 대한 요청핸들러 메소드
	@RequestMapping("/logout.do")
	public String logout() {
		// 세션에서 로그인된 사용자 정보 삭제
		SessionUtils.removeAttribute("LOGINED_USER");

		return "redirect:home.do";
	}

	// yogiyo/register.do 요청에 대한 요청핸들러 메소드
	@RequestMapping("/register.do")
	public String register(UserForm userForm) throws IOException {
		if (!userForm.getPassword().equals(userForm.getPassword2())) {
			return "redirect:form.do?error=mismatch";
		}

		// User객체를 생성해서 UserForm객체의 값을 복사한다.
		User user = new User();
		BeanUtils.copyProperties(userForm, user);

		try {
			userService.insertNewUser(user);
		} catch (DuplicatedUserIdException e) {
			e.printStackTrace();
			return "redirect:form.do?error=dup";
		}
		return "redirect:home.do";
	}
}
