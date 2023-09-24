package com.alinesno.infra.common.security.mapper.jackson;

import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;

import com.alinesno.infra.common.core.context.SpringContext;
import com.alinesno.infra.common.security.mapper.annotation.SensitiveField;
import com.alinesno.infra.common.security.mapper.enums.SensitiveStrategy;
import com.alinesno.infra.common.security.mapper.service.SensitiveService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import cn.hutool.core.util.ObjectUtil;

/**
 * 数据脱敏json序列化工具
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class SensitiveJsonSerializer extends JsonSerializer<String> implements ContextualSerializer {

	private static final Logger log = LoggerFactory.getLogger(SensitiveJsonSerializer.class);

	private SensitiveStrategy strategy;

	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		try {
			SensitiveService sensitiveService = SpringContext.getBean(SensitiveService.class);
			if (ObjectUtil.isNotNull(sensitiveService) && sensitiveService.isSensitive()) {
				gen.writeString(strategy.desensitizer().apply(value));
			} else {
				gen.writeString(value);
			}
		} catch (BeansException e) {
			log.error("脱敏实现不存在, 采用默认处理 => {}", e.getMessage());
			gen.writeString(value);
		}
	}

	@Override
	public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
			throws JsonMappingException {
		SensitiveField annotation = property.getAnnotation(SensitiveField.class);
		if (Objects.nonNull(annotation) && Objects.equals(String.class, property.getType().getRawClass())) {
			this.strategy = annotation.strategy();
			return this;
		}
		return prov.findValueSerializer(property.getType(), property);
	}
}
