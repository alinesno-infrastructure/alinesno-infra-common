package com.alinesno.infra.common.web.adapter.sso.enable;

import com.alinesno.infra.common.web.adapter.enable.EnableInfraApi;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 登陆初始化
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EnableInfraApi
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ SsoApiConfigurationSelector.class })
public @interface EnableInfraSsoApi {

}
