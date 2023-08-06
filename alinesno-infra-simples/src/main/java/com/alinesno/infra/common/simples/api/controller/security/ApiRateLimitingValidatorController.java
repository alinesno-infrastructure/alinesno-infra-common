package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]接口API的限流配置,针对接口API的请求量进行限制，防止恶意请求和过载情况对系统造成影响。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class ApiRateLimitingValidatorController {
    private static final Logger log = LoggerFactory.getLogger(ApiRateLimitingValidatorController.class);

}
