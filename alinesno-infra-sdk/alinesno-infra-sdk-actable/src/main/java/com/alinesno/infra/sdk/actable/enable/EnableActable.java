package com.alinesno.infra.sdk.actable.enable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 支持消息接收
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
//@MapperScan("com.gitee.sunchenbin.mybatis.actable.dao.*")
//@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*"})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ ActableConfigurationSelector.class })
public @interface EnableActable {

}
