package com.alinesno.infra.common.web.adapter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源服务器配置白名单列表，允许配置内的规则匿名访问
 *
 * @author luoandon@gmail.com
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "alinesno.infra")
@Component
public class WhiteListDefine {

	private List<String> anons = new ArrayList<String>();

	public List<String> getAnons() {
		return anons;
	}

	public WhiteListDefine setAnons(List<String> anons) {
		this.anons = anons;
		return this;
	}
}
