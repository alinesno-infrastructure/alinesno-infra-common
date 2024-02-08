package com.alinesno.infra.common.core.encrypt.encryptor;

import com.alinesno.infra.common.core.constants.AlgorithmType;
import com.alinesno.infra.common.core.constants.EncodeType;
import com.alinesno.infra.common.core.encrypt.EncryptContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@DisplayName("Base64Encryptor 单元测试")
public class Base64EncryptorTest {

    @Test
    @DisplayName("测试 algorithm 方法")
    public void testAlgorithm() {
        EncryptContext context = mock(EncryptContext.class);
        Base64Encryptor encryptor = new Base64Encryptor(context);

        AlgorithmType result = encryptor.algorithm();

        assertEquals(AlgorithmType.BASE64, result);
    }

    @Test
    @DisplayName("测试 encrypt 方法")
    public void testEncrypt() {
        EncryptContext context = mock(EncryptContext.class);
        Base64Encryptor encryptor = new Base64Encryptor(context);

        String result = encryptor.encrypt("test", EncodeType.BASE64);

        assertEquals("dGVzdA==", result);
    }

    @Test
    @DisplayName("测试 decrypt 方法")
    public void testDecrypt() {
        EncryptContext context = mock(EncryptContext.class);
        Base64Encryptor encryptor = new Base64Encryptor(context);

        String result = encryptor.decrypt("dGVzdA==");

        assertEquals("test", result);
    }
}
