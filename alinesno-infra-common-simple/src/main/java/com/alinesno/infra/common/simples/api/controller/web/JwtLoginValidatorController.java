package com.alinesno.infra.common.simples.api.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]普通JWT前后端登录,确保只有经过身份验证和授权的用户才能访问敏感接口API。使用合适的身份验证机制。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class JwtLoginValidatorController {
    private static final Logger log = LoggerFactory.getLogger(JwtLoginValidatorController.class);

}
