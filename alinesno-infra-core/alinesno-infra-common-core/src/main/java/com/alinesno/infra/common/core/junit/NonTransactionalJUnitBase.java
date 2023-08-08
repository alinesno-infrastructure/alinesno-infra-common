package com.alinesno.infra.common.core.junit;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class NonTransactionalJUnitBase {

    /**
     * 在测试方法执行前进行一些初始化操作
     */
    @Before
    public void setUp() {
        System.err.println("--------------------------------- 非提交事务测试开始 --------------------------------");
        // 进行一些初始化操作
    }
}
