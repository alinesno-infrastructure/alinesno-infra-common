package com.alinesno.infra.common.security.mapper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.alinesno.infra.common.security.mapper.enums.SensitiveStrategy;
import com.alinesno.infra.common.security.mapper.jackson.SensitiveJsonSerializer;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 数据脱敏加密
 * 
 * @author LuoAnDong
 * @date 2023年7月21日 06:43:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveJsonSerializer.class)
public @interface SensitiveField {

	SensitiveStrategy strategy();

}
