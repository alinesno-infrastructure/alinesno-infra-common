package com.alinesno.infra.common.simples.api.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]XSS攻击防护,防止系统受到跨站脚本攻击，保护用户的信息安全。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class XSSProtectionValidatorController {
    private static final Logger log = LoggerFactory.getLogger(XSSProtectionValidatorController.class);

}
