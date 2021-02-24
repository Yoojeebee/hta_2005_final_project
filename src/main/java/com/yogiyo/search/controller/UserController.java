package com.yogiyo.search.controller;

import java.io.IOException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/form.do")
	public String form() {
		return "form";   //         /WEB-INF/views/form.jsp로 내부이동
	}

	@RequestMapping("/loginform.do")
	public String loginform() {
		return "loginform";   //      /WEB-INF/views/loginform.jsp로 내부이동
	}

	@RequestMapping("/login.do")
	public String login(@RequestParam("id") String userId, @RequestParam("password") String password) {
		System.out.println("아이디 : " + userId);
		System.out.println("비밀번호 : " + password);

		if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
			return "redirect:loginform.do?error=empty";   // id, password값이 비어있으면 로그인폼을 요청하는 URL을 응답으로 보낸다.
		}
		try {
			User user = userService.getLoginedUserInfo(userId, password);
			// 세션에 로그인된 사용자정보를 저장한다.
			SessionUtils.setAttribute("LOGINED_USER", user);

			System.out.println("로그인 된 사용자 정보 : " + user);

		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return "redirect:loginform.do?error=notfound";
		} catch (PasswordMismatchException e) {
			e.printStackTrace();
			return "redirect:loginform.do?error=mismatch";
		}
		return "redirect:home.do";
	}

	@RequestMapping("/logout.do")
	public String logout() {
		// 세션에서 로그인된 사용자 정보 삭제
		SessionUtils.removeAttribute("LOGINED_USER");

		return "redirect:home.do";
	}

	@RequestMapping("/checkUserId.do")
	public ModelAndView checkUserId(@RequestParam("userId") String userId) {
		ModelAndView mav = new ModelAndView();

		boolean isExist = userService.isExistUserId(userId);
		if (isExist) {
			mav.addObject("message", "사용중");
		} else {
			mav.addObject("message", "사용가능");
		}

		return mav;
	}

	@RequestMapping("/register.do")
	public String register(UserForm userForm) throws IOException {
		if (!userForm.getPassword().equals(userForm.getPassword2())) {
			return "redirect:form.do?error=mismatch";
		}

		// User객체를 생성해서 UserForm객체의 값을 복사한다.
		User user = new User();
		BeanUtils.copyProperties(userForm, user);

		// 클라이언트에서 업로드한 첨부파일을 지정된 위치의 디렉토리에 복사하기
		try {
			userService.insertNewUser(user);
		} catch (DuplicatedUserIdException e) {
			e.printStackTrace();
			return "redirect:form.do?error=dup";
		}
		return "redirect:home.do";
	}
}
