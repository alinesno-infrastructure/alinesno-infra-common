package com.alinesno.infra.common.feign.annotation;

import com.dtflys.forest.annotation.MethodLifeCycle;
import com.dtflys.forest.annotation.RequestAttributes;

import java.lang.annotation.*;

/**
 * 自定义请求路径加密和加权配置
 * @author luoxiaodong
 * @since 2023年8月1日 上午6:23:43
 */
@Documented
@MethodLifeCycle(HttpAuthLifeCycle.class)
@RequestAttributes
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface HttpAuth {

    /**
     * 自定义注解的属性：用户名
     * 所有自定注解的属性可以在生命周期类中被获取到
     */
    String username();

    /**
     * 自定义注解的属性：密码
     * 所有自定注解的属性可以在生命周期类中被获取到
     */
    String password();
}
