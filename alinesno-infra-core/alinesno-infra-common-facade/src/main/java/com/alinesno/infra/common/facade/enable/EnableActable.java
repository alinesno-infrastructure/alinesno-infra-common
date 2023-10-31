package com.alinesno.infra.common.facade.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

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
