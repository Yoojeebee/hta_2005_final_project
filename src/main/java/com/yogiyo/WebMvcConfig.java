package com.yogiyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yogiyo.owner.intercepter.OwnerLoginInteceptor;
import com.yogiyo.owner.intercepter.StoreInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	OwnerLoginInteceptor ownerLoginInterceptor;
	
	@Autowired
	StoreInterceptor storeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ownerLoginInterceptor)
				.addPathPatterns(ownerLoginInterceptor.loginHTML);
		
		registry.addInterceptor(storeInterceptor)
				.addPathPatterns(storeInterceptor.login);
	}

}
