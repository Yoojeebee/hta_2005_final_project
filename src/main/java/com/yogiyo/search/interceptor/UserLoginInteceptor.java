package com.yogiyo.search.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yogiyo.owner.dao.OwnerDao;
import com.yogiyo.search.exception.PasswordMismatchException;
import com.yogiyo.search.exception.UserNotFoundException;
import com.yogiyo.search.service.UserService;
import com.yogiyo.search.vo.User;
import com.yogiyo.util.SessionUtils;

@Component
public class UserLoginInteceptor implements HandlerInterceptor {
	
	@Autowired
	UserService userService;
	
	public List<String> login = Arrays.asList("/login.do");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String id = (String)request.getParameter("id");
		String password = (String)request.getParameter("password");
		
		if(id != null && password != null) {
			try {
				User user = userService.getLoginedUserInfo(id, password);
				System.out.println(user.toString());
				request.getSession().setAttribute("LOGINED_USER", user);
				request.getSession().setMaxInactiveInterval(-1);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
				response.sendRedirect("/loginform.do?error=notfound");
				return false;
			} catch (PasswordMismatchException e) {
				e.printStackTrace();
				response.sendRedirect("/loginform.do?error=mismatch");
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
