package com.alinesno.infra.common.feign.annotation;

import com.dtflys.forest.annotation.Headers;

import java.lang.annotation.*;

/**
 * 自定义注解方式
 * @author luoxiaodong
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
