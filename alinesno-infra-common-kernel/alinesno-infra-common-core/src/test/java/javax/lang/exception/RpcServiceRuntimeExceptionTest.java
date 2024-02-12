package javax.lang.exception;

import com.alinesno.infra.common.core.junit.NonSpringBootJUnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 类名：RpcServiceRuntimeExceptionTest
 * 描述：这是一个示例的JUnit单元测试类，用于测试RpcServiceRuntimeException类的方法。
 *
 * 注意：在编写单元测试时，应该覆盖各种可能的情况，包括正常情况和异常情况，并验证方法的返回值是否符合预期。
 * 这里只给出了针对RpcServiceRuntimeException类的部分方法的示例，你可以根据需要添加更多的测试方法。
 *
 * @author  luoxiaodong
 * @version 1.0.0
 */
public class RpcServiceRuntimeExceptionTest extends NonSpringBootJUnitBase {
    private RpcServiceRuntimeException rpcServiceRuntimeException;

    /**
     * 在每个测试方法执行之前执行的方法，用于初始化测试环境。
     */
    @BeforeEach
    public void setUp() {
        // 初始化测试对象
        rpcServiceRuntimeException = new RpcServiceRuntimeException();
    }

    /**
     * 测试方法：testGetCode
     * 描述：测试getCode方法，验证获取异常的返回码是否正确。
     */
    @Test
    public void testGetCode() {
        // 设置测试数据
        String code = "500";
        rpcServiceRuntimeException.setCode(code);

        // 执行被测试的方法
        String result = rpcServiceRuntimeException.getCode();

        // 验证方法的结果
        Assertions.assertEquals(code, result, "返回值不符合预期");
    }

    /**
     * 测试方法：testSetMessage
     * 描述：测试setMessage方法，验证设置异常的描述信息是否正确。
     */
    @Test
    public void testSetMessage() {
        // 设置测试数据
        String message = "Test message";

        // 执行被测试的方法
        rpcServiceRuntimeException.setMessage(message);

        // 验证方法的结果
        Assertions.assertEquals(message, rpcServiceRuntimeException.getMessage(), "返回值不符合预期");
    }

    /**
     * 测试方法：testGetThreadInfo
     * 描述：测试getThreadInfo方法，验证获取异常的线程信息是否正确。
     */
    @Test
    public void testGetThreadInfo() {
        // 设置测试数据
        String threadInfo = "Thread info";
        rpcServiceRuntimeException.setThreadInfo(threadInfo);

        // 执行被测试的方法
        String result = rpcServiceRuntimeException.getThreadInfo();

        // 验证方法的结果
        Assertions.assertEquals(threadInfo, result, "返回值不符合预期");
    }
}
