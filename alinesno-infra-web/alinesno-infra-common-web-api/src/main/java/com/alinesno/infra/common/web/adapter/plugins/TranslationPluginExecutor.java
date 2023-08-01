package com.alinesno.infra.common.web.adapter.plugins;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.core.context.SpringContext;

/**
 * 字段转换插件执行器
 *
 * @author luoandon@gmail.com
 * @date 2019/8/27
 */
public class TranslationPluginExecutor {
	private final static Logger log = LoggerFactory.getLogger(TranslationPluginExecutor.class);

	/**
	 * 执行插件
	 *
	 * @param array       数据列表，可多个也可包装单个
	 * @param convertCode 字段转换配置
	 * @return 转换后的数据列表
	 */
	public static List<JSONObject> execute(List<JSONObject> array, TranslateCode convertCode) {
		String pluginName = convertCode.plugin();
		// 优先执行平台插件
		for (Class<? extends TranslatePlugin> c : PluginRegistry.query()) {
			TranslatePlugin plugin = SpringContext.getBean(c);
			try {
				plugin.translate(array, convertCode);
			} catch (Exception e) {
				log.error("代码{} , 代码转换异常:{}", pluginName, e);
			}
		}
		// 执行自定义插件
		if (StringUtils.isNotBlank(pluginName)) {
			TranslatePlugin selfP = (TranslatePlugin) SpringContext.getBean(pluginName);
			try {
				selfP.translate(array, convertCode);
			} catch (Exception e) {
				log.error("插件{} , 转换值:{} , 代码转换异常:{}", pluginName, array, e);
			}
		}
		return array;
	}
}
