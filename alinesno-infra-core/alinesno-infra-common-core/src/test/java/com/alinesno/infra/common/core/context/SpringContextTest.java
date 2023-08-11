package com.alinesno.infra.common.core.context;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("SpringContext 单元测试")
public class SpringContextTest {

    @Test
    @DisplayName("测试 setApplicationContext 方法")
    public void testSetApplicationContext() {
        ApplicationContext applicationContext = mock(ApplicationContext.class);
        SpringContext springContext = new SpringContext();

        springContext.setApplicationContext(applicationContext);

        ApplicationContext result = SpringContext.getApplicationContext();
        assertEquals(applicationContext, result);
    }

    @Test
    @DisplayName("测试 getBean 方法 - 通过name获取 Bean")
    public void testGetBean_ByName() {
        ApplicationContext applicationContext = mock(ApplicationContext.class);
        Object expected = new Object();
        when(applicationContext.getBean("testBean")).thenReturn(expected);
//        SpringContext.setApplicationContext(applicationContext);

        Object result = SpringContext.getBean("testBean");

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试 getBean 方法 - 通过class获取 Bean")
    public void testGetBean_ByClass() {
        ApplicationContext applicationContext = mock(ApplicationContext.class);
        TestBean expected = new TestBean();
        when(applicationContext.getBean(TestBean.class)).thenReturn(expected);
//        SpringContext.setApplicationContext(applicationContext);

        TestBean result = SpringContext.getBean(TestBean.class);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试 getObjectProvider 方法")
    public void testGetObjectProvider() {
        ApplicationContext applicationContext = mock(ApplicationContext.class);
        TestBean bean1 = new TestBean();
        TestBean bean2 = new TestBean();
        when(applicationContext.getBeanProvider(TestBean.class)).thenReturn(mock(ObjectProvider.class));
        when(applicationContext.getBeanProvider(TestBean.class).stream()).thenReturn(Stream.of(bean1, bean2));
//        SpringContext.setApplicationContext(applicationContext);

        List<TestBean> result = SpringContext.getObjectProvider(TestBean.class);

        assertEquals(2, result.size());
        assertTrue(result.contains(bean1));
        assertTrue(result.contains(bean2));
    }

    @Test
    @DisplayName("测试 getBean 方法 - 通过name和class获取 Bean")
    public void testGetBean_ByNameAndClass() {
        ApplicationContext applicationContext = mock(ApplicationContext.class);
        TestBean expected = new TestBean();
        when(applicationContext.getBean("testBean", TestBean.class)).thenReturn(expected);
//        SpringContext.setApplicationContext(applicationContext);

        TestBean result = SpringContext.getBean("testBean", TestBean.class);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试 context 方法")
    public void testContext() {
        ApplicationContext applicationContext = mock(ApplicationContext.class);
//        SpringContext.setApplicationContext(applicationContext);

        ApplicationContext result = SpringContext.context();

        assertEquals(applicationContext, result);
    }

    private static class TestBean {
        // 测试用的内部类
    }
}
