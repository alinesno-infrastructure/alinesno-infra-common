package com.alinesno.infra.common.core.annotations;

import com.alinesno.infra.common.facade.enums.BusinessType;
import com.alinesno.infra.common.facade.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 日誌操作記錄
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logger {

    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;

    /**
     * 排除指定的请求参数
     */
    String[] excludeParamNames() default {};
}
