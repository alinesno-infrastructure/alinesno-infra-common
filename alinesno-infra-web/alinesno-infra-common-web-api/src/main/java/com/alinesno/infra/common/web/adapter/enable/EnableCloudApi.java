package com.alinesno.infra.common.web.adapter.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 支持消息接收
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ CloudApiConfigurationSelector.class })
public @interface EnableCloudApi {

}
