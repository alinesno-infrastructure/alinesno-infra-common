package com.alinesno.infra.common.web.adapter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 跨域配置
 * 
 * @author luoxiaodong
 * @since 2019年8月9日 上午6:23:43
 */
@ConfigurationProperties(prefix = "alinesno.cors")
public class CORSProperites {

	private List<String> allowedOrigins;
	private boolean allowCredentials;
	private String allowMethods;
	private String allowHeaders;

	public List<String> getAllowedOrigins() {
		return allowedOrigins;
	}

	public void setAllowedOrigins(List<String> allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	}

	public boolean isAllowCredentials() {
		return allowCredentials;
	}

	public void setAllowCredentials(boolean allowCredentials) {
		this.allowCredentials = allowCredentials;
	}

	public String getAllowMethods() {
		return allowMethods;
	}

	public void setAllowMethods(String allowMethods) {
		this.allowMethods = allowMethods;
	}

	public String getAllowHeaders() {
		return allowHeaders;
	}

	public void setAllowHeaders(String allowHeaders) {
		this.allowHeaders = allowHeaders;
	}

}
