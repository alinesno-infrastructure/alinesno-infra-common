package com.alinesno.infra.common.security.mapper.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.alinesno.infra.common.core.constants.AlgorithmType;
import com.alinesno.infra.common.core.constants.EncodeType;

/**
 * 字段加密注解
 * 
 * @author LuoAnDong
 * @date 2023年7月21日 06:43:10
 */
@Documented
@Inherited
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptField {

	/**
	 * 加密算法
	 */
	AlgorithmType algorithm() default AlgorithmType.DEFAULT;

	/**
	 * 秘钥。AES、SM4需要
	 */
	String password() default "";

	/**
	 * 公钥。RSA、SM2需要
	 */
	String publicKey() default "";

	/**
	 * 私钥。RSA、SM2需要
	 */
	String privateKey() default "";

	/**
	 * 编码方式。对加密算法为BASE64的不起作用
	 */
	EncodeType encode() default EncodeType.DEFAULT;

}
