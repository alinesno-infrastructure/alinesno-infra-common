package com.alinesno.infra.common.core.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ValidateMobile 单元测试")
public class ValidateMobileTest {

    private final ValidateMobile validator = new ValidateMobile();

    @Test
    @DisplayName("测试 isValid 方法 - 手机号为空")
    public void testIsValid_Empty() {
        String value = "";
        ConstraintValidatorContext context = null;

        boolean result = validator.isValid(value, context);

        assertFalse(result);
    }

    @Test
    @DisplayName("测试 isValid 方法 - 手机号格式不正确")
    public void testIsValid_InvalidFormat() {
        String value = "123456789";
        ConstraintValidatorContext context = null;

        boolean result = validator.isValid(value, context);

        assertFalse(result);
    }

    @Test
    @DisplayName("测试 isValid 方法 - 手机号格式正确")
    public void testIsValid_ValidFormat() {
        String value = "13812345678";
        ConstraintValidatorContext context = null;

        boolean result = validator.isValid(value, context);

        assertTrue(result);
    }
}
