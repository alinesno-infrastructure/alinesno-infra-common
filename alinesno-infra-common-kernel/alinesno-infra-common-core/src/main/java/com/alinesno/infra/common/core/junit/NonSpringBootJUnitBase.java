package com.alinesno.infra.common.core.junit;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 非Spring Boot的单元测试基类，便于其他单元测试类继承，并提供一些通用的方法。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class NonSpringBootJUnitBase {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 在每个测试方法执行之前执行的方法，用于初始化测试环境。
     */
    @Before
    public void setUp() {
        log.info("--------------------------------- 单元测试开始 --------------------------------");
        // 在这里可以进行测试环境的初始化
    }

    /**
     * 在每个测试方法执行之后执行的方法，用于清理测试环境。
     */
    @After
    public void endUp() {
        log.info("--------------------------------- 单元测试结束 --------------------------------");
        // 在这里可以进行测试环境的清理
    }

}
