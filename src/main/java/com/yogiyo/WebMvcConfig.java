package com.yogiyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yogiyo.owner.intercepter.OwnerLoginInteceptor;
import com.yogiyo.owner.intercepter.StoreInterceptor;
import com.yogiyo.search.interceptor.UserLoginInteceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	UserLoginInteceptor userLoginInteceptor;
	
	@Autowired
	OwnerLoginInteceptor ownerLoginInteceptor;
	
	@Autowired
	StoreInterceptor storeInteceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userLoginInteceptor)
				.addPathPatterns(userLoginInteceptor.login);
		
		registry.addInterceptor(ownerLoginInteceptor)
				.addPathPatterns(ownerLoginInteceptor.loginHTML);
		
		registry.addInterceptor(storeInteceptor)
				.addPathPatterns(storeInteceptor.login);
	}

}
