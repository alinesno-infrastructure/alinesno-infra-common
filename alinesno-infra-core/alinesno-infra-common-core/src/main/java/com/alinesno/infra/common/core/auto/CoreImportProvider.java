package com.alinesno.infra.common.core.auto;

import com.alinesno.infra.common.core.cache.RedisConfig;
import com.alinesno.infra.common.core.config.AsyncConfig;
import com.alinesno.infra.common.core.context.SpringContext;
import com.alinesno.infra.common.core.exceptions.aspect.RpcServiceExceptionAspect;
import com.alinesno.infra.common.core.utils.WebUploadUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对外提供核心对象,便于springboot实现enable功能
 * 
 * @author luoxiaodong
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

		s.add(SpringContext.class.getName());
		s.add(AsyncConfig.class.getName()); // 添加异步线程池
		s.add(RedisConfig.class.getName()); // Redis配置
		s.add(WebUploadUtils.class.getName());

		// 数据库源
		// s.add(MyBatisPlusConfig.class.getName());

		// Dubbo统一异常处理
		s.add(RpcServiceExceptionAspect.class.getName());

		return s;
	}

}
