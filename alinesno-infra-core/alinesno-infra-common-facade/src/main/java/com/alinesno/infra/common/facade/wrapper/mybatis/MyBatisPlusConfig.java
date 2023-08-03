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
import com.alinesno.infra.common.facade.wrapper.mybatis.plugins.CreateAndUpdateMetaInject;
import com.alinesno.infra.common.facade.wrapper.mybatis.plugins.PlusDataPermissionInterceptor;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

import cn.hutool.core.net.NetUtil;

/**
 * MyBatis Plus分页配置
 *
 * @author LuoAnDong
 * @since 2018年1月3日 上午11:17:11
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

		// 分页插件
		interceptor.addInnerInterceptor(paginationInnerInterceptor());

		// 数据权限处理
		interceptor.addInnerInterceptor(dataPermissionInterceptor());

		return interceptor;
	}

	/**
	 * 数据权限拦截器
	 */
	public PlusDataPermissionInterceptor dataPermissionInterceptor() {
		return new PlusDataPermissionInterceptor();
	}

	/**
	 * 分页插件，自动识别数据库类型
	 */
	public PaginationInnerInterceptor paginationInnerInterceptor() {
		PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
		// 设置最大单页限制数量，默认 500 条，-1 不受限制
		paginationInnerInterceptor.setMaxLimit(-1L);
		// 分页合理化
		paginationInnerInterceptor.setOverflow(true);
		return paginationInnerInterceptor;
	}

	/**
	 * 乐观锁插件
	 */
	public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
		return new OptimisticLockerInnerInterceptor();
	}

	/**
	 * 元对象字段填充控制器
	 */
	@Bean
	public MetaObjectHandler metaObjectHandler() {
		return new CreateAndUpdateMetaInject();
	}

	/**
	 * 使用网卡信息绑定雪花生成器 防止集群雪花ID重复
	 */
	@Bean
	public IdentifierGenerator idGenerator() {
		return new DefaultIdentifierGenerator(NetUtil.getLocalhost());
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
