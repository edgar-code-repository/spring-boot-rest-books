package com.showcase.books.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class CorsConfiguration extends WebMvcConfigurerAdapter {
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry
    		.addMapping("/**")
    		.allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
    		.allowedOrigins("*")
    		.allowedHeaders("Content-Type", "X-Requested-With", "Accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization")
        	.exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
    }
	

}
