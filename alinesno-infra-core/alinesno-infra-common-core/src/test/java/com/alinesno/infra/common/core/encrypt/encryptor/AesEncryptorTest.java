package com.alinesno.infra.common.core.encrypt.encryptor;

import com.alinesno.infra.common.core.constants.AlgorithmType;
import com.alinesno.infra.common.core.constants.EncodeType;
import com.alinesno.infra.common.core.encrypt.EncryptContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("AesEncryptor 单元测试")
public class AesEncryptorTest {

    @Test
    @DisplayName("测试构造函数 - 秘钥长度不符合要求")
    public void testConstructor_InvalidPasswordLength() {
        EncryptContext context = mock(EncryptContext.class);
        when(context.getPassword()).thenReturn("abc");
        assertThrows(IllegalArgumentException.class, () -> new AesEncryptor(context));
    }

    @Test
    @DisplayName("测试构造函数 - 秘钥为空")
    public void testConstructor_NullPassword() {
        EncryptContext context = mock(EncryptContext.class);
        when(context.getPassword()).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> new AesEncryptor(context));
    }

    @Test
    @DisplayName("测试构造函数 - 创建AES实例")
    public void testConstructor_CreateAesInstance() {
        EncryptContext context = mock(EncryptContext.class);
        when(context.getPassword()).thenReturn("1234567890123456");
        AesEncryptor encryptor = new AesEncryptor(context);

//        AES aes = encryptor.getAesInstance();
//
//        assertNotNull(aes);
//        assertEquals("1234567890123456", new String(aes.getKey(), StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("测试 algorithm 方法")
    public void testAlgorithm() {
        EncryptContext context = mock(EncryptContext.class);
        when(context.getPassword()).thenReturn("1234567890123456");
        AesEncryptor encryptor = new AesEncryptor(context);

        AlgorithmType result = encryptor.algorithm();

        assertEquals(AlgorithmType.AES, result);
    }

    @Test
    @DisplayName("测试 encrypt 方法 - 使用 HEX 编码")
    public void testEncrypt_HexEncode() {
        EncryptContext context = mock(EncryptContext.class);
        when(context.getPassword()).thenReturn("1234567890123456");
        AesEncryptor encryptor = new AesEncryptor(context);

        String result = encryptor.encrypt("test", EncodeType.HEX);

        assertEquals("f3a1f9fbc2e2e8e4c6dcf9e9", result);
    }

    @Test
    @DisplayName("测试 encrypt 方法 - 使用 Base64 编码")
    public void testEncrypt_Base64Encode() {
        EncryptContext context = mock(EncryptContext.class);
        when(context.getPassword()).thenReturn("1234567890123456");
        AesEncryptor encryptor = new AesEncryptor(context);

        String result = encryptor.encrypt("test", EncodeType.BASE64);

        assertEquals("8aH5vC4u6O9nM2RzN5k=", result);
    }

    @Test
    @DisplayName("测试 decrypt 方法")
    public void testDecrypt() {
        EncryptContext context = mock(EncryptContext.class);
        when(context.getPassword()).thenReturn("1234567890123456");
        AesEncryptor encryptor = new AesEncryptor(context);

        String result = encryptor.decrypt("f3a1f9fbc2e2e8e4c6dcf9e9");

        assertEquals("test", result);
    }

    private static class TestEncryptContext extends EncryptContext {
        @Override
        public String getPassword() {
            return "1234567890123456";
        }
    }
}
