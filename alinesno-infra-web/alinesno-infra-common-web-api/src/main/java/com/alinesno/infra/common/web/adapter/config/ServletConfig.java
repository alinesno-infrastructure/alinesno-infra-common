package com.alinesno.infra.common.web.adapter.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * fix:处理vue404页面的问题
 * 
 * @author luoxiaodong
 * @since 2019年4月19日 下午10:23:43
 */
@Configuration
public class ServletConfig {
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
		return factory -> {
			ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
			factory.addErrorPages(errorPage);
		};
	}
}
