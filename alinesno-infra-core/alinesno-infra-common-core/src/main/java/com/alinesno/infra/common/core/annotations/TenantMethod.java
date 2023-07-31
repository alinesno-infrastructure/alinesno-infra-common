package com.alinesno.infra.common.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TenantMethod {

	// 方法
	public enum TenantMethodEnums {
		GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
	}

	String name() default "";

	String[] path() default {};

	TenantMethodEnums[] method() default {};// 枚举数组
}