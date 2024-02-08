package com.alinesno.infra.common.simples.api.controller.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * [功能]多数据源事务（jta atomikos）,支持在多数据源的情况下进行事务管理，保证数据的一致性和完整性。
 * author luoxiaodong
 * version 1.0.0
 */
@RestController
public class MultiDataSourceTransactionValidatorController {
    private static final Logger log = LoggerFactory.getLogger(MultiDataSourceTransactionValidatorController.class);

}
