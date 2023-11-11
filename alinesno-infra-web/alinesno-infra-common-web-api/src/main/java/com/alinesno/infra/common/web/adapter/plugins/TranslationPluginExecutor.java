package com.alinesno.infra.common.web.adapter.plugins;

import com.alinesno.infra.common.core.context.SpringContext;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 字段转换插件执行器
 *
 * @author luoandon@gmail.com
 * @version 1.0.0
 */
@Slf4j
public class TranslationPluginExecutor {

	/**
	 * 执行插件
	 *
	 * @param array       数据列表，可多个也可包装单个
	 * @param convertCode 字段转换配置
	 * @return 转换后的数据列表
	 */
	public static ArrayNode execute(ArrayNode array, TranslateCode convertCode) {
		String pluginName = convertCode.plugin();
		// 优先执行平台插件
		for (Class<? extends TranslatePlugin> c : PluginRegistry.query()) {
			TranslatePlugin plugin = SpringContext.getBean(c);
			try {
				plugin.translate(array, convertCode);
			} catch (Exception e) {
				log.error("代码{} , 代码转换异常:{}", pluginName, e.getMessage());
			}
		}
		// 执行自定义插件
		if (StringUtils.isNotBlank(pluginName)) {
			TranslatePlugin selfP = (TranslatePlugin) SpringContext.getBean(pluginName);
			try {
				selfP.translate(array, convertCode);
			} catch (Exception e) {
				log.error("插件{} , 转换值:{} , 代码转换异常:{}", pluginName, array, e.getMessage());
			}
		}
		return array;
	}
}
