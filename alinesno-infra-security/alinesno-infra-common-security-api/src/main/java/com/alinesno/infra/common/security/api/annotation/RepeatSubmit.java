package com.alinesno.infra.common.security.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 自定义注解防止表单重复提交
 *
 * @author Lion Li
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {

	/**
	 * 间隔时间(ms)，小于此时间视为重复提交
	 */
	int interval() default 5000;

	TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

	/**
	 * 提示消息 支持国际化 格式为 {code}
	 */
	String message() default "{repeat.submit.message}";

}
