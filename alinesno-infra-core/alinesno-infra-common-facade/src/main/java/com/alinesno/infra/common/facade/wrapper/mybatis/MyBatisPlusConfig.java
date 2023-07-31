package com.alinesno.infra.common.facade.wrapper.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.alinesno.infra.common.facade.wrapper.mybatis.inject.EntityFieldInjectPlugin;
import com.alinesno.infra.common.facade.wrapper.mybatis.inject.EntityFieldInjectProcessor;
import com.alinesno.infra.common.facade.wrapper.mybatis.inject.InnerInjectPlugin;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

/**
 * MyBatis Plus分页配置
 *
 * @author LuoAnDong
 * @since 2021年1月3日 上午11:17:11
 */
@Configuration
public class MyBatisPlusConfig {

	/**
	 * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor =
	 * false 避免缓存出现问题
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}

	@SuppressWarnings("deprecation")
	@Bean
	public ConfigurationCustomizer configurationCustomizer() {
		return configuration -> configuration.setUseDeprecatedExecutor(false);
	}

	@Bean
	public EntityFieldInjectPlugin innerPlugin() {
		return new InnerInjectPlugin();
	}

	/**
	 * 自动填充功能
	 */
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Primary
	@Autowired
	public MetaObjectHandler metaObjectHandler(List<EntityFieldInjectPlugin> plugins) {
		return new EntityFieldInjectProcessor(plugins);
	}
}
