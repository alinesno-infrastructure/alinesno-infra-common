package com.alinesno.infra.common.simples.api.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]多数据源分库分表（读写分离）,支持将数据分布在多个数据库中，实现读写分离和数据的水平扩展。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class MultiDataSourceShardingValidatorController {
    private static final Logger log = LoggerFactory.getLogger(MultiDataSourceShardingValidatorController.class);

}
