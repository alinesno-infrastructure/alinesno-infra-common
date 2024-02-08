package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]接口API的防SQL注入/防XSS攻击,针对接口API的输入进行过滤和验证，防止SQL注入和跨站脚本攻击。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class ApiSecurityValidationValidatorController {
    private static final Logger log = LoggerFactory.getLogger(ApiSecurityValidationValidatorController.class);

}
