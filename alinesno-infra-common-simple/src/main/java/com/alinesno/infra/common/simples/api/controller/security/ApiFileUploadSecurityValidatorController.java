package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]接口API的文件上传安全限制,对接口API的文件上传进行安全限制，包括文件类型、大小、文件名等的验证和限制。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class ApiFileUploadSecurityValidatorController {
    private static final Logger log = LoggerFactory.getLogger(ApiFileUploadSecurityValidatorController.class);

}
