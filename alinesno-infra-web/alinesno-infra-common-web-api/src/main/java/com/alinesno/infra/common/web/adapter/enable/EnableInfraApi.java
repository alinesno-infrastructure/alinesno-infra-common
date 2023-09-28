package com.alinesno.infra.common.web.adapter.enable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.alinesno.infra.common.core.auto.EnableCore;
import org.springframework.context.annotation.Import;

/**
 * 登陆初始化
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EnableCore
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ ApiConfigurationSelector.class })
public @interface EnableInfraApi {

}
