package com.alinesno.infra.common.core.annotations;

import java.lang.annotation.*;

/**
 * 數據權限
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {

}
