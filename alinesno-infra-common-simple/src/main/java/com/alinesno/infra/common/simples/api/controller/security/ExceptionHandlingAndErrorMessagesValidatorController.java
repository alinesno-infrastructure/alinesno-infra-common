package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]异常处理和错误信息,在接口API中，避免向用户返回具体的错误信息，以防止信息泄露和攻击者利用这些信息。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class ExceptionHandlingAndErrorMessagesValidatorController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlingAndErrorMessagesValidatorController.class);

}
