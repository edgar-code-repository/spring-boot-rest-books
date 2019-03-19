package com.showcase.books.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class CheckAllInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(CheckAllInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		logger.info("[CheckAllInterceptor][preHandle][INICIO]");
		logger.info("[CheckAllInterceptor][preHandle][RequestURL: " + request.getRequestURL() + "]");
		logger.info("[CheckAllInterceptor][preHandle][Request Method: " + request.getMethod() + "]");		
		
        logger.info("[CheckAllInterceptor][preHandle][FIN]");	
		return true;		
		
	}

}
