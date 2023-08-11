package com.alinesno.infra.common.core.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
/**
 * 类名：DateConverterConfigTest
 * 描述：这是一个示例的JUnit单元测试类，用于测试DateConverterConfig类的方法。
 *
 * 注意：这个示例测试类假设DateConverterConfig类中的方法已经正确实现，并且依赖的配置属性已经正确注入。
 *      如果您的实际情况有所不同，请根据需要进行修改和调整。
 *
 * 作者：YourName
 * 版本：1.0.0
 */
@DisplayName("DateConverterConfig 单元测试")
public class DateConverterConfigTest {

    private DateConverterConfig converter = new DateConverterConfig();

    @Test
    @DisplayName("测试 convert 方法 - 格式为 yyyy-MM")
    public void testConvert_YearMonthFormat() {
        String source = "2022-08";
        Date expected = createDate(2022, 8, 1, 0, 0, 0);

        Date result = converter.convert(source);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试 convert 方法 - 格式为 yyyy-MM-dd")
    public void testConvert_DateFormat() {
        String source = "2022-08-11";
        Date expected = createDate(2022, 8, 11, 0, 0, 0);

        Date result = converter.convert(source);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试 convert 方法 - 格式为 yyyy-MM-dd HH:mm")
    public void testConvert_DateTimeFormat() {
        String source = "2022-08-11 12:30";
        Date expected = createDate(2022, 8, 11, 12, 30, 0);

        Date result = converter.convert(source);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试 convert 方法 - 格式为 yyyy-MM-dd HH:mm:ss")
    public void testConvert_FullDateTimeFormat() {
        String source = "2022-08-11 12:30:45";
        Date expected = createDate(2022, 8, 11, 12, 30, 45);

        Date result = converter.convert(source);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试 convert 方法 - 无效日期格式")
    public void testConvert_InvalidFormat() {
        String source = "2022-08-11 12:30:45.123";

        assertThrows(IllegalArgumentException.class, () -> converter.convert(source));
    }

    private Date createDate(int year, int month, int day, int hour, int minute, int second) {
        return new Date(year - 1900, month - 1, day, hour, minute, second);
    }
}
