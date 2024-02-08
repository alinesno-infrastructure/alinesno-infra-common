package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]接口API防越权配置,控制用户对接口API的访问权限，防止越权访问和未授权操作。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class ApiAuthorizationConfigurationValidatorController {
    private static final Logger log = LoggerFactory.getLogger(ApiAuthorizationConfigurationValidatorController.class);

}
