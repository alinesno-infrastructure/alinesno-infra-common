package com.alinesno.infra.common.feign.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dtflys.forest.annotation.Headers;

/**
 * 自定义注解方式
 * @author LuoAnDong
 * @since 2023年8月1日 上午6:23:43
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Headers({
        "Accept: text/plain",
        "Content-Type: application/json",
        "Token: ${token}"
})
public @interface GloablHeaders {
}
