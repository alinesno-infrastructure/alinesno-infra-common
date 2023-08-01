package com.alinesno.infra.common.web.adapter.plugins;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 字段转换注解
 * </p>
 * <p>
 * 当此注解用在controller上时会自动对通用字段进行可读性转换
 * <p/>
 * <p>
 * 也可实现自定义的装换插件实现，参见 TranslatePlugin
 * </p>
 *
 * @author zhuogm
 * @see TranslatePlugin
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TranslateCode {

	/**
	 * 类型
	 *
	 * @return
	 */
	public String types() default "";

	/**
	 * 是否转换父类平台账号
	 * 
	 * @return
	 */
	public boolean platform() default true;

	/**
	 * 转换的字段
	 *
	 * @return
	 */
	public String value() default "";

	/**
	 * 自定义插件实现,必须是 Spring Bean<br />
	 * 取值为bean 的 name，否则将会无法执行转换
	 *
	 * @return
	 */
	public String plugin() default "";

	/**
	 * 应用的字段
	 *
	 * @return
	 */
	public String applicationField() default "applicationId";

	/**
	 * 所属资源
	 *
	 * @return
	 */
	public String resourceField() default "";

	/**
	 * 是否转换操作员
	 *
	 * @return
	 */
	public boolean operator() default true;

	/**
	 * 操作员字段
	 *
	 * @return
	 */
	public String operatorField() default "operatorId";

	/**
	 * 租户字段
	 *
	 * @return
	 */
	public String tenantField() default "tenantId";
}