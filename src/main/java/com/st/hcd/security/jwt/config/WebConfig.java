package com.st.hcd.security.jwt.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})

//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	//@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	
	    CommonsMultipartResolver multipartResolver 
	            = new CommonsMultipartResolver();
	    return multipartResolver;
	    
	}
}