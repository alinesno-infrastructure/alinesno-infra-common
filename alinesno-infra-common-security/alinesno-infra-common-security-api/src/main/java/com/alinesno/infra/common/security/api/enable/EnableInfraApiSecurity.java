package com.alinesno.infra.common.security.api.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 登陆初始化
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ ApiSecurityConfigurationSelector.class })
public @interface EnableInfraApiSecurity {

}
