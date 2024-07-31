package com.application.gamescore.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private AuthInterceptorAdmin authInterceptorAdmin;
	
	String[] adminAccessModifierList = {"/admin/insertGame", "/admin/updateGame"};
	
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) { 		// addInterceptors 메서드로 Interceptor 설정 지정
        registry.addInterceptor(authInterceptorAdmin)			 		// Interceptor로직을 사용할 객체를 지정
        		.order(1)                                    			// Interceptor 우선순위를 지정
                //.addPathPatterns("/admin/*" , "/management/*");		// Interceptor를 적용할 URL 패턴을 지정
        		.addPathPatterns(adminAccessModifierList);			 	// Interceptor를 적용할 URL 패턴을 지정
        
    }
	
	
}
