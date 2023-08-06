package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]双因子认证安全，主要集成TOPT安全，实现双因子认证的安全机制，提供额外的身份验证保护。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class TwoFactorAuthenticationValidatorController {
    private static final Logger log = LoggerFactory.getLogger(TwoFactorAuthenticationValidatorController.class);
}
