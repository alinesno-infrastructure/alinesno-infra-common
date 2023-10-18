package com.alinesno.infra.common.facade.wrapper.mybatis.inject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 平台实体类字段注入插件抽象
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface EntityFieldInjectPlugin {
	/**
	 * 执行insert语句时注入实体类字段值 执行sql语句前会调用此函数实现字段注入
	 *
	 * @param metaObject mybatis plus 层透传的元数据对象配置
	 * @param processor  字段注入器，用于注入数据对象的字段值
	 */
	void insertFill(MetaObject metaObject, MetaObjectHandler processor);

	/**
	 * 执行update语句时注入实体类字段值，执行sql语句前会调用此函数实现注入
	 *
	 * @param metaObject mybatis plus 层透传的元数据对象配置
	 * @param processor  字段注入器，用于注入数据对象的字段值
	 */
	void updateFill(MetaObject metaObject, MetaObjectHandler processor);

	/**
	 * 指定插件执行的顺序，值越小优先级越高( 0 > 1 > 2 ) 对同一个字段执行注入时优先级高的插件会覆盖优先级低的插件设置的字段值
	 *
	 * @return 优先级
	 */
	long order();

	/**
	 * 提供一个插件名，默认取当前实现类名
	 *
	 * @return 插件名
	 */
	default String name() {
		return this.getClass().getName();
	}
}
