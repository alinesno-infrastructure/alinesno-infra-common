package com.alinesno.infra.common.core.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 类名：AsyncConfigTest
 * 描述：这是一个示例的JUnit单元测试类，用于测试AsyncConfig类的方法。
 *
 * 注意：这个示例测试类假设AsyncConfig类中的方法已经正确实现，并且依赖的配置属性已经正确注入。
 *      如果您的实际情况有所不同，请根据需要进行修改和调整。
 *
 * 作者：YourName
 * 版本：1.0.0
 */
@Configuration
@EnableAsync
public class AsyncConfigTest {

    @Test
    @DisplayName("测试 getAsyncExecutor 方法")
    public void testGetAsyncExecutor() {
        AsyncConfig asyncConfig = new AsyncConfig();
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) asyncConfig.getAsyncExecutor();

        Assertions.assertEquals(2, taskExecutor.getCorePoolSize(), "核心线程数设置错误");
        Assertions.assertEquals(5, taskExecutor.getMaxPoolSize(), "最大线程数设置错误");
        Assertions.assertEquals(20, taskExecutor.getQueueCapacity(), "线程队列最大线程数设置错误");
    }

    @Test
    @DisplayName("测试 getAsyncUncaughtExceptionHandler 方法")
    public void testGetAsyncUncaughtExceptionHandler() {
        AsyncConfig asyncConfig = new AsyncConfig();
        AsyncUncaughtExceptionHandler exceptionHandler = asyncConfig.getAsyncUncaughtExceptionHandler();

        Assertions.assertNull(exceptionHandler, "异常处理方法设置错误");
    }

}
