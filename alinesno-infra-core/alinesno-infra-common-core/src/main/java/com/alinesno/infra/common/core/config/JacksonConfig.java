package com.alinesno.infra.common.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * JacksonConfig 类配置了 Jackson 库的对象映射，用于处理 JSON 序列化和反序列化。
 * 如果未定义 ObjectMapper bean，则创建并配置一个默认的 ObjectMapper bean。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Configuration
public class JacksonConfig {

    /**
     * 创建一个名为 jacksonObjectMapper 的 ObjectMapper bean。
     * 如果不存在 ObjectMapper 类的 bean，则使用默认配置。
     * 全局配置序列化返回 JSON 处理，包括将 Long 类型转换为 String 类型。
     *
     * @param builder Jackson2ObjectMapperBuilder 实例，用于构建 ObjectMapper 对象。
     * @return 配置完成的 ObjectMapper 对象。
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        
        // 创建一个 SimpleModule 用于定制序列化规则
        SimpleModule simpleModule = new SimpleModule();
        
        // 将 Long 类型序列化为 String 类型以防止精度丢失
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        
        // 注册定制的 SimpleModule
        objectMapper.registerModule(simpleModule);
        
        return objectMapper;
    }
}
