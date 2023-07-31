package com.alinesno.cloud.rest.gateway.adapter.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author luoandon@gmail.com
 * @date 2019/7/12
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class CorsFilter implements Filter {

	@Autowired
	private CORSProperites corsProperites ; 
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		
		// 允许所有的域访问，可以设置只允许自己的域访问
		response.setHeader("Access-Control-Allow-Origin", corsProperites.getAllowedOrigins()==null?"*" :corsProperites.getAllowedOrigins().toString());
		// 允许所有方式的请求
		response.setHeader("Access-Control-Allow-Methods", corsProperites.getAllowMethods()==null? "*" : corsProperites.getAllowMethods());
		// 头信息缓存有效时长（如果不设 Chromium 同时规定了一个默认值 5 秒），没有缓存将已OPTIONS进行预请求
		response.setHeader("Access-Control-Max-Age", "3600");
		// 允许的头信息
		response.setHeader("Access-Control-Allow-Headers", "*");
		// 处理x-json
		response.setHeader("Access-Control-Expose-Headers", "Content-Length, X-JSON");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, res);
		}
	}
}
