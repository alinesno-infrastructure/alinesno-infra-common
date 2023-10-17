package com.alinesno.infra.common.facade.wrapper.mybatis.inject;

import java.time.Instant;
import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * 平台内置注入插件
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class InnerInjectPlugin implements EntityFieldInjectPlugin {
	/**
	 * 执行insert语句时注入实体类字段值 执行sql语句前会调用此函数实现字段注入
	 *
	 * @param metaObject mybatis plus 层透传的元数据对象配置
	 * @param processor  字段注入器，用于注入数据对象的字段值
	 */
	@Override
	public void insertFill(MetaObject metaObject, MetaObjectHandler processor) {
		Date now = Date.from(Instant.now());
		processor.strictInsertFill(metaObject, "addTime", Date.class, now);
		processor.strictInsertFill(metaObject, "hasStatus", Integer.class, 0);
		processor.strictInsertFill(metaObject, "updateTime", Date.class, now);
	}

	/**
	 * 执行update语句时注入实体类字段值，执行sql语句前会调用此函数实现注入
	 *
	 * @param metaObject mybatis plus 层透传的元数据对象配置
	 * @param processor  字段注入器，用于注入数据对象的字段值
	 */
	@Override
	public void updateFill(MetaObject metaObject, MetaObjectHandler processor) {
		metaObject.setValue("updateTime", Date.from(Instant.now()));
	}

	/**
	 * 指定插件执行的顺序，值越小优先级越高，越早执行
	 *
	 * @return 优先级
	 */
	@Override
	public long order() {
		return Long.MIN_VALUE;
	}
}
