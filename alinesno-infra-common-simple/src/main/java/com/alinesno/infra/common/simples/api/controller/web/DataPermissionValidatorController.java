package com.alinesno.infra.common.simples.api.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]数据权限,控制用户对数据的访问权限，确保用户只能访问其具备权限的数据。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class DataPermissionValidatorController {
    private static final Logger log = LoggerFactory.getLogger(DataPermissionValidatorController.class);

}
