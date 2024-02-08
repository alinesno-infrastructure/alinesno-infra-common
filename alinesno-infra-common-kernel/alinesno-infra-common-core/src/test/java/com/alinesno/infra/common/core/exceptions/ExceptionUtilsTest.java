//package com.alinesno.infra.common.core.exceptions;
//
//import com.alinesno.infra.common.core.exception.ExceptionUtils;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DisplayName("ExceptionUtils 单元测试")
//public class ExceptionUtilsTest {
//
//    @Test
//    @DisplayName("测试 buildMessage 方法 - 有根本原因")
//    public void testBuildMessage_WithCause() {
//        String message = "Base message";
//        Throwable cause = new RuntimeException("Root cause");
//
//        String result = ExceptionUtils.buildMessage(message, cause);
//
//        String expected = "Base message; nested exception is java.lang.RuntimeException: Root cause";
//        assertEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("测试 buildMessage 方法 - 无根本原因")
//    public void testBuildMessage_WithoutCause() {
//        String message = "Base message";
//        Throwable cause = null;
//
//        String result = ExceptionUtils.buildMessage(message, cause);
//
//        assertEquals(message, result);
//    }
//
//    @Test
//    @DisplayName("测试 getExcTrace 方法")
//    public void testGetExcTrace() {
//        Exception exception = new Exception("Test exception");
//
//        String result = ExceptionUtils.getExcTrace(exception);
//
//        // 预期结果：异常的堆栈信息字符串
//        // 请根据您的实际情况修改预期结果
//        String expected = "java.lang.Exception: Test exception\n\tat com.alinesno.infra.common.core.exceptions.ExceptionUtilsTest.testGetExcTrace(ExceptionUtilsTest.java:31)\n\t...";
//
//        assertEquals(expected, result);
//    }
//}
