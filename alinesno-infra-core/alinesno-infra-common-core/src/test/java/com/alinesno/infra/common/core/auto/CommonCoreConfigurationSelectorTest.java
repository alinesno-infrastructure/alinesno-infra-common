package com.alinesno.infra.common.core.auto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 类名：CommonCoreConfigurationSelectorTest
 * 描述：这是一个示例的JUnit单元测试类，用于测试CommonCoreConfigurationSelector类的方法。
 *
 * 作者：luoxiaodong
 * 版本：1.0.0
 */
public class CommonCoreConfigurationSelectorTest {
    private CommonCoreConfigurationSelector configurationSelector;
    private AnnotationMetadata annotationMetadata;

    /**
     * 在每个测试方法执行之前执行的方法，用于初始化测试环境。
     */
    @BeforeEach
    public void setUp() {
        configurationSelector = new CommonCoreConfigurationSelector();
        annotationMetadata = null; // 可以根据需要进行初始化
    }

    /**
     * 测试方法：testSelectImports
     * 描述：这是一个示例的测试方法，用于测试CommonCoreConfigurationSelector类的selectImports方法。
     */
    @Test
    @DisplayName("测试 selectImports 方法")
    public void testSelectImports() {
        String[] imports = configurationSelector.selectImports(annotationMetadata);

        Assertions.assertNotNull(imports, "selectImports 方法返回值不能为空");
        Assertions.assertTrue(imports.length > 0, "selectImports 方法返回值应包含导入的类");

        // 可以根据实际情况进一步验证导入的类
        // Assertions.assertTrue(Arrays.asList(imports).contains("com.example.SomeClass"), "导入的类不符合预期");
        // ...
    }

    /**
     * 测试方法：testGetAnnotationClass
     * 描述：这是一个示例的测试方法，用于测试CommonCoreConfigurationSelector类的getAnnotationClass方法。
     */
    @Test
    @DisplayName("测试 getAnnotationClass 方法")
    public void testGetAnnotationClass() {
        Class<?> annotationClass = configurationSelector.getAnnotationClass();

        Assertions.assertEquals(EnableCore.class, annotationClass, "getAnnotationClass 方法返回值不符合预期");
    }
}
