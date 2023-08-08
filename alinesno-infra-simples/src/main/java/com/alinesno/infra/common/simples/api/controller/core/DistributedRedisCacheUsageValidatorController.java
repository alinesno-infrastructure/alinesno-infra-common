package com.alinesno.infra.common.simples.api.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]分布式Redis缓存使用,在分布式环境下使用Redis作为缓存，支持多个节点之间的数据同步和共享。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class DistributedRedisCacheUsageValidatorController {
    private static final Logger log = LoggerFactory.getLogger(DistributedRedisCacheUsageValidatorController.class);

}
