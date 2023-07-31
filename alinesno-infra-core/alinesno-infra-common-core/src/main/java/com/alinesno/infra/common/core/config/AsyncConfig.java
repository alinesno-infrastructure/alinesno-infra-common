package com.alinesno.infra.common.core.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 添加异常执行方法
 * 
 * @author WeiXiaoJin
 * @since 2019年6月19日 下午9:17:19
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

	@Value("${thread-pool-factory.core-pool-size:2}")
	private int corePoolSize;

	@Value("${thread-pool-factory.max-pool-size:5}")
	private int maxPoolSize;

	@Value("${thread-pool-factory.queue-capacity:20}")
	private int queueCapacity;

	/**
	 * 异步执行线程池
	 */
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor(); // 定义线程池
		taskExecutor.setCorePoolSize(corePoolSize); // 核心线程数
		taskExecutor.setMaxPoolSize(maxPoolSize); // 线程池最大线程数
		taskExecutor.setQueueCapacity(queueCapacity); // 线程队列最大线程数
		taskExecutor.initialize(); // 初始化
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
}