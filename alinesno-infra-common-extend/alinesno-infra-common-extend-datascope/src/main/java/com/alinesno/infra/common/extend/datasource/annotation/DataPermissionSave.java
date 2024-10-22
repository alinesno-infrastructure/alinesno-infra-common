package com.alinesno.infra.common.extend.datasource.annotation;

import java.lang.annotation.*;

/**
 * 数据权限保存注入
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermissionSave {

}
