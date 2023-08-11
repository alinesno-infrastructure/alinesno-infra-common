package com.alinesno.infra.common.core.encrypt.encryptor;

import com.alinesno.infra.common.core.constants.AlgorithmType;
import com.alinesno.infra.common.core.constants.EncodeType;
import com.alinesno.infra.common.core.encrypt.EncryptContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sm4Encryptor 单元测试")
public class Sm4EncryptorTest {

    @Test
    @DisplayName("测试 encrypt 方法 - 使用 HEX 编码")
    public void testEncrypt_Hex() {
        EncryptContext context = new EncryptContext();
        context.setPassword("1234567890123456");
        Sm4Encryptor encryptor = new Sm4Encryptor(context);

        String value = "Hello, World!";
        String result = encryptor.encrypt(value, EncodeType.HEX);

        assertNotNull(result);
        assertNotEquals(value, result);
    }

    @Test
    @DisplayName("测试 encrypt 方法 - 使用 Base64 编码")
    public void testEncrypt_Base64() {
        EncryptContext context = new EncryptContext();
        context.setPassword("1234567890123456");
        Sm4Encryptor encryptor = new Sm4Encryptor(context);

        String value = "Hello, World!";
        String result = encryptor.encrypt(value, EncodeType.BASE64);

        assertNotNull(result);
        assertNotEquals(value, result);
    }

    @Test
    @DisplayName("测试 decrypt 方法")
    public void testDecrypt() {
        EncryptContext context = new EncryptContext();
        context.setPassword("1234567890123456");
        Sm4Encryptor encryptor = new Sm4Encryptor(context);

        String value = "encrypted value";
        String encrypted = encryptor.encrypt(value, EncodeType.HEX);

        String result = encryptor.decrypt(encrypted);

        assertEquals(value, result);
    }

    @Test
    @DisplayName("测试 algorithm 方法")
    public void testAlgorithm() {
        EncryptContext context = new EncryptContext();
        context.setPassword("1234567890123456");
        Sm4Encryptor encryptor = new Sm4Encryptor(context);

        AlgorithmType result = encryptor.algorithm();

        assertEquals(AlgorithmType.SM4, result);
    }
}
