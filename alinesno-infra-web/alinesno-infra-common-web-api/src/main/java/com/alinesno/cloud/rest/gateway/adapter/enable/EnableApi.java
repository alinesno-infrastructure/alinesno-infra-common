package com.alinesno.cloud.rest.gateway.adapter.enable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * 支持消息接收
 * 
 * @author WeiXiaoJin
 * @since 2019年4月9日 上午11:29:00
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ ApiConfigurationSelector.class })
public @interface EnableApi {

}
