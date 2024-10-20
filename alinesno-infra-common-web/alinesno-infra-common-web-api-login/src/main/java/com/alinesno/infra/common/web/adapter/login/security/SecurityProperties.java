package com.alinesno.infra.common.web.adapter.login.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;

/**
 * Security 配置属性
 *
 * @author luoxiaodong
 */
@Primary
@Data
@ConfigurationProperties(prefix = "alinesno.security")
public class SecurityProperties {

    /**
     * 排除路径
     */
    private String[] excludes;


}
