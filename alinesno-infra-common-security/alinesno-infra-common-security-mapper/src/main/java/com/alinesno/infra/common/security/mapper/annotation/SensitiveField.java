package com.alinesno.infra.common.security.mapper.annotation;

import com.alinesno.infra.common.security.mapper.enums.SensitiveStrategy;
import com.alinesno.infra.common.security.mapper.jackson.SensitiveJsonSerializer;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据脱敏加密
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveJsonSerializer.class)
public @interface SensitiveField {

	SensitiveStrategy strategy();

}
