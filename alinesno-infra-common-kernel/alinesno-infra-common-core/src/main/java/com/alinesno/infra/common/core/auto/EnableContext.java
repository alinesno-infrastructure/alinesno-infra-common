package com.alinesno.infra.common.core.auto;

import org.springframework.context.annotation.ImportResource;

import java.lang.annotation.*;

/**
 * alinesno-cloud的web引导服务,包含有前端，登陆等服务组件
 * 
 * @author luoxiaodong
 * @sine 2019年4月5日 上午11:32:55
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ImportResource(locations = { "classpath:spring/spring-context.xml" })
public @interface EnableContext {

	// //扫描feign包下的，变成接口可调用包

	/**
	 * If true, the ServiceRegistry will automatically register the local server.
	 */
	boolean autoRegister() default true;
}
