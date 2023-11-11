package com.alinesno.infra.common.web.adapter.plugins;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.alinesno.infra.common.web.adapter.utils.StringUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 转换插件接口
 *
 * @author luoxiaodong
 * @since 2019年4月7日 下午2:24:08
 */
public interface TranslatePlugin {

	// 日志记录
	static final Logger log = LoggerFactory.getLogger(TranslatePlugin.class);
	String LABEL_SUFFER = "Label";

	// 创建一个ObjectMapper对象
	ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 字段转换插件，用于将id等不可读字段转换后追加在请求响应内
	 *
	 * @param node        当前响应的数据列表，为保证响应性能自定义实现应该做批量查询，避免逐个查询
	 * @param convertCode 自定义配置
	 */
	public void translate(ArrayNode node, TranslateCode convertCode);

	/**
	 * 抽取数据id列表
	 *
	 * @param idField     指定id字段名
	 * @param jsonObjects json数据列表
	 * @return 指定id字段合集
	 */
	default List<String> extractIds(ArrayNode jsonObjects, String idField) {
		if (jsonObjects != null && StringUtils.isNotBlank(idField)) {

			List<String> ids = new ArrayList<>() ;

			// 遍历数组
			for (JsonNode elementNode : jsonObjects) {
				// 获取数组元素的值
				String id = elementNode.get(idField).toString() ;
				ids.add(id) ;
			}

			return ids ;
		}
		return Collections.emptyList();
	}

	/**
	 * 根据id集合转换成实体Map集合
	 *
	 * @param entities 数据服务
	 * @return Map<id, entity>
	 */
	@SuppressWarnings("rawtypes")
	default <T> Map toEntityMap(List<? extends BaseEntity> entities) {

		if (!entities.isEmpty()) {
			return entities.parallelStream().collect(Collectors.toMap(BaseEntity::getId, entity -> entity));
		}
		return Collections.emptyMap();
	}

}
