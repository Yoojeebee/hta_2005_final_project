package com.yogiyo.review.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class SessionUtils {

	// 세션객체에 지정된 이름으로 값을 저장한다
	public static void setAttribute(String name, Object value) {
		RequestContextHolder.getRequestAttributes()
		.setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
		
	}
	
	// 세션객체에 지정된 이름으로 저장된 속성값을 반환한다
	public static void removeAttribute(String name) {
		RequestContextHolder.getRequestAttributes()
		.removeAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	// 세션객체에 지정된 이름으로 저장된 속성값을 반환한다
	public static Object getAttribute(String name) {
		return RequestContextHolder.getRequestAttributes()
				.getAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
}
