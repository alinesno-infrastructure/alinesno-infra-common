package com.alinesno.infra.common.simples.api.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]接口API的防重复提交,防止接口API被重复提交，避免重复操作和数据不一致的问题。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class ApiDuplicateSubmissionValidatorController {
    private static final Logger log = LoggerFactory.getLogger(ApiDuplicateSubmissionValidatorController.class);

}
