package com.yogiyo.owner.intercepter;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yogiyo.owner.dao.OwnerDao;

@Component
public class OwnerLoginInteceptor implements HandlerInterceptor {
	
	@Autowired
	OwnerDao ownerDao;
	
	public List<String> loginHTML = Arrays.asList("/owner/**");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 로그인 처리를 위해 파라미터 값 id를 확인
		String id = (String)request.getParameter("id");
		System.out.println("id = " + id);
		if(id != null) {
			request.getSession().setAttribute("OWNER_NO", ownerDao.getOwnerNo(id));
			return true;
		}

		String logout = (String)request.getRequestURI();
		if(request.getSession().getAttribute("OWNER_NO") != null && logout.equals("/owner/logout")) {
			request.getSession().removeAttribute("OWNER_NO");
			return true;
		}

		// 세션 객체에서 로그인이 되어 있는 오너
		if((String)request.getSession().getAttribute("OWNER_NO") != null) {
			response.sendRedirect("/store/home");
			return false;
		}
		
		// 세션 객체에 로그인이 되어 있지 않은 오너
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
