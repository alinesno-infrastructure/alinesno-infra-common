package com.alinesno.infra.common.web.adapter.plugins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 平台自有插件注册器
 *
 * @author luoxiaodong
 * @since 2019年4月7日 下午2:46:18
 */
class PluginRegistry {

	private static final Map<String, Class<? extends TranslatePlugin>> plugins = new HashMap<>();

	/**
	 * 初始化插件
	 */
	public static void init() {
//		regist(ApplicationPlugin.class); // 应用代码转换注册
//		regist(ManagerAccounntPlugin.class); // 操作员转换注册
//		regist(TenantPlugin.class); // 操作员转换注册
	}

	static {
		init();
	}

	/**
	 * 插件注册
	 *
	 * @param c
	 * @return
	 */
	public static void regist(Class<? extends TranslatePlugin> c) {
		plugins.put(c.getName(), c);
	}

	public static List<Class<? extends TranslatePlugin>> query() {
		List<Class<? extends TranslatePlugin>> list = new ArrayList<>();
		for (String k : plugins.keySet()) {
			list.add(plugins.get(k));
		}

		return list;
	}

}
