package com.alinesno.infra.common.metrics.core.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.CollectorRegistry;

/**
 * 集成Prometheus默认配置
 * @author LuoAnDong
 * @date 2023年7月21日 06:43:10
 */
@AutoConfiguration
public class PrometheusConfiguration {
	
	@Autowired
    private CollectorRegistry collectorRegistry;

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config()
        		.commonTags("application", applicationName)
        		.commonTags("alinesno_infra" , "v1.0")
        		;
    }

}