package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]日志输出打印安全，主要包括加密和数据配置，对系统日志进行安全处理，包括加密敏感信息和配置适当的日志级别。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class LogSecurityValidatorController {
    private static final Logger log = LoggerFactory.getLogger(LogSecurityValidatorController.class);
}
