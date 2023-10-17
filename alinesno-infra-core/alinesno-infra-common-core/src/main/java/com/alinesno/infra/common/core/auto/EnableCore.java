package com.alinesno.infra.common.core.auto;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

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
@Import({ CommonCoreConfigurationSelector.class })
public @interface EnableCore {

	// //扫描feign包下的，变成接口可调用包

	/**
	 * If true, the ServiceRegistry will automatically register the local server.
	 */
	boolean autoRegister() default true;
}
