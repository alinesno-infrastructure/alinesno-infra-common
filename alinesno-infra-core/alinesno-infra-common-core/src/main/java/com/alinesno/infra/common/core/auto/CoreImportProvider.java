package com.alinesno.infra.common.core.auto;

import java.util.ArrayList;
import java.util.List;

import com.alinesno.infra.common.core.cache.CacheRedisUtil;
import com.alinesno.infra.common.core.cache.RedisConfig;
import com.alinesno.infra.common.core.config.AsyncConfig;
import com.alinesno.infra.common.core.context.ApplicationContextProvider;
import com.alinesno.infra.common.core.exceptions.aspect.RpcServiceExceptionAspect;
import com.alinesno.infra.common.core.utils.WebUploadUtils;
import com.alinesno.infra.common.facade.wrapper.mybatis.MyBatisPlusConfig;

/**
 * 对外提供核心对象,便于springboot实现enable功能
 * 
 * @author WeiXiaoJin
 * @since 2019年4月7日 下午2:41:44
 */
public class CoreImportProvider {

	/**
	 * 提供接口对象
	 * 
	 * @return
	 */
	public static List<String> classLoader() {
		List<String> s = new ArrayList<>();

		s.add(ApplicationContextProvider.class.getName());
		s.add(AsyncConfig.class.getName()); // 添加异步线程池
		s.add(RedisConfig.class.getName()); // Redis配置
		s.add(CacheRedisUtil.class.getName()); // Redis配置
		s.add(WebUploadUtils.class.getName()); // Redis配置

		// 数据库源
		s.add(MyBatisPlusConfig.class.getName());

		// Dubbo统一异常处理
		s.add(RpcServiceExceptionAspect.class.getName());

		return s;
	}

}
