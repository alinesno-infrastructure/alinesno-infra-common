package com.alinesno.infra.common.core.junit;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring Boot的单元测试基类，便于其他单元测试类继承，并提供一些通用的方法。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SprignBootJUnitBase {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Rule
	public ContiPerfRule iRule = new ContiPerfRule();

	/**
	 * 开始测试
	 */
	@Before
	public void setUp() {
		System.err.println("--------------------------------- 单元测试开始 --------------------------------");
	}

	@After
	public void endUp() {
		System.err.println("--------------------------------- 单元测试结束 --------------------------------");
	}

}
