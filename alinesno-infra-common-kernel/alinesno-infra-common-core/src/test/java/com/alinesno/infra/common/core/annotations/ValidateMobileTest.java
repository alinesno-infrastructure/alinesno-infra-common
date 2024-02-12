package com.alinesno.infra.common.core.annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

/**
 * 类名：ValidateMobileTest
 * 描述：这是一个示例的JUnit单元测试类，用于测试ValidateMobile类的方法。
 *
 * @author  luoxiaodong
 * @version 1.0.0
 */
public class ValidateMobileTest {
    private ValidateMobile validateMobile;
    private ConstraintValidatorContext constraintValidatorContext;

    /**
     * 在每个测试方法执行之前执行的方法，用于初始化测试环境。
     */
    @BeforeEach
    public void setUp() {
        validateMobile = new ValidateMobile();
        constraintValidatorContext = null; // 可以根据需要进行初始化
    }

    /**
     * 测试方法：testIsValidWithEmptyMobile
     * 描述：这是一个示例的测试方法，用于测试ValidateMobile类的isValid方法，当手机号为空时的情况。
     */
    @Test
    @DisplayName("测试 isValid 方法 - 验证手机号为空")
    public void testIsValidWithEmptyMobile() {
        String mobile = "";

        boolean isValid = validateMobile.isValid(mobile, constraintValidatorContext);

        Assertions.assertFalse(isValid, "手机号为空时应返回 false");
    }

    /**
     * 测试方法：testIsValidWithInvalidMobileFormat
     * 描述：这是一个示例的测试方法，用于测试ValidateMobile类的isValid方法，当手机号格式不正确时的情况。
     */
    @Test
    @DisplayName("测试 isValid 方法 - 验证手机号格式不正确")
    public void testIsValidWithInvalidMobileFormat() {
        String mobile = "123456789"; // 手机号格式不正确

        boolean isValid = validateMobile.isValid(mobile, constraintValidatorContext);

        Assertions.assertFalse(isValid, "手机号格式不正确时应返回 false");
    }

    /**
     * 测试方法：testIsValidWithValidMobileFormat
     * 描述：这是一个示例的测试方法，用于测试ValidateMobile类的isValid方法，当手机号格式正确时的情况。
     */
    @Test
    @DisplayName("测试 isValid 方法 - 验证手机号格式正确")
    public void testIsValidWithValidMobileFormat() {
        String mobile = "13812345678"; // 手机号格式正确

        boolean isValid = validateMobile.isValid(mobile, constraintValidatorContext);

        Assertions.assertTrue(isValid, "手机号格式正确时应返回 true");
    }
}
