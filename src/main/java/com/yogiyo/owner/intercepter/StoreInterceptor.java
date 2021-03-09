package com.yogiyo.owner.intercepter;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yogiyo.owner.dao.OwnerDao;
import com.yogiyo.util.SessionUtils;
import com.yogiyo.owner.dao.OStoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StoreInterceptor implements HandlerInterceptor {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	OStoreDao storeDao;

	public List<String> login = Arrays.asList("/store/home", "/store/manage/joinStore", "/store/manage/menu");
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// owner/login에서 로그인이 완료될 시 파라미터 id의 값을 받아
		// id가 존재하면 id의 값을 기준으로 오너 테이블에서 id에 해당하는 owner_no의 값을 받아 session에 저장
		String id = (String)request.getParameter("id");
		if(id != null) {
			request.getSession().setAttribute("OWNER_NO", ownerDao.getOwnerNo(id));
			System.out.println("id = " + (String)SessionUtils.getAttribute("OWNER_NO"));
			// 로그아웃을 하지 않은 이상 로그인 유지
			request.getSession().setMaxInactiveInterval(-1);
		}

		// 로그인이 되어 있지 않은 오너
		if ((String)request.getSession().getAttribute("OWNER_NO") == null) {
			response.sendRedirect("/owner/login");
			return false;
		}


//		if((String)request.getRequestURL().toString() == (url + "manage/menu")) {
//			storeDao.get
//		}

		// 로그인이 되어 있는 오너
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
