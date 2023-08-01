package com.alinesno.infra.common.facade.wrapper.mybatis.inject;

import java.util.Comparator;
import java.util.List;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * 平台字段填充插件处理器 通过定制 mybatis plugin 填充插件实现多插件注入执行
 * 并且用法和原生插件风格一致，为各个组件实现不同的字段注入需求提供支持
 *
 * @author WeiXiaoJin
 */
public class EntityFieldInjectProcessor implements MetaObjectHandler {
	private static final Logger logger = LoggerFactory.getLogger(EntityFieldInjectProcessor.class);
	private final List<EntityFieldInjectPlugin> plugins;

	public EntityFieldInjectProcessor(List<EntityFieldInjectPlugin> plugins) {
		this.plugins = plugins;
		// 按照插件优先级排序，倒序执行
		plugins.sort(Comparator.comparingLong(EntityFieldInjectPlugin::order).reversed());
		logger.info("{} auto inject field plugins was found", plugins.size());
	}

	/**
	 * 插入元对象字段填充（用于插入时对公共字段的填充）
	 *
	 * @param metaObject 元对象
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
		for (EntityFieldInjectPlugin plugin : plugins) {
			try {
				plugin.insertFill(metaObject, this);
				logger.info("execution inject plugin {} on phase insertFill()", plugin.name());
			} catch (Exception e) {
				logger.error("error when execute inject plugin {} on phase insertFill()", plugin.name(), e);
			}
		}
	}

	/**
	 * 更新元对象字段填充（用于更新时对公共字段的填充）
	 *
	 * @param metaObject 元对象
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
		for (EntityFieldInjectPlugin plugin : plugins) {
			try {
				plugin.insertFill(metaObject, this);
				logger.info("execution inject plugin {} on phase updateFill()", plugin.name());
			} catch (Exception e) {
				logger.error("error when execute inject plugin {} on phase updateFill()", plugin.name(), e);
			}
		}
	}
}
