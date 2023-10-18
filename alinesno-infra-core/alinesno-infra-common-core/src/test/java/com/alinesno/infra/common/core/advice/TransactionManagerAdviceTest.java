package com.alinesno.infra.common.core.advice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.aop.Advisor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TransactionManagerAdvice 单元测试")
public class TransactionManagerAdviceTest {
    private TransactionManagerAdvice transactionManagerAdvice;

    @Mock
    private PlatformTransactionManager transactionManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionManagerAdvice = new TransactionManagerAdvice();
        transactionManagerAdvice.transactionManager = transactionManager;
    }

    @Test
    @DisplayName("测试 txAdvice 方法")
    public void testTxAdvice() {
        TransactionInterceptor txAdvice = transactionManagerAdvice.txAdvice();

        assertNotNull(txAdvice, "返回值不应为空");
        assertEquals(transactionManager, txAdvice.getTransactionManager(), "transactionManager 应该被正确设置");

        NameMatchTransactionAttributeSource source = (NameMatchTransactionAttributeSource) txAdvice.getTransactionAttributeSource();
        assertNotNull(source, "TransactionAttributeSource 不应为空");

        Map<String, TransactionAttribute> methodMap =  null ; // source.getNameMap();
        assertNotNull(methodMap, "methodMap 不应为空");

        // 验证方法规则是否正确设置
        assertTrue(methodMap.containsKey("add*"), "add* 方法应该存在");
        assertTrue(methodMap.containsKey("save*"), "save* 方法应该存在");
        assertTrue(methodMap.containsKey("update*"), "update* 方法应该存在");
        assertTrue(methodMap.containsKey("modify*"), "modify* 方法应该存在");
        assertTrue(methodMap.containsKey("edit*"), "edit* 方法应该存在");
        assertTrue(methodMap.containsKey("insert*"), "insert* 方法应该存在");
        assertTrue(methodMap.containsKey("delete*"), "delete* 方法应该存在");
        assertTrue(methodMap.containsKey("remove*"), "remove* 方法应该存在");
        assertTrue(methodMap.containsKey("repair*"), "repair* 方法应该存在");
        assertTrue(methodMap.containsKey("binding*"), "binding* 方法应该存在");
        assertTrue(methodMap.containsKey("*"), "* 方法应该存在");

        TransactionAttribute requiredTx = methodMap.get("add*");
        assertNotNull(requiredTx, "add* 方法的 TransactionAttribute 不应为空");
        assertTrue(requiredTx instanceof RuleBasedTransactionAttribute, "add* 方法的 TransactionAttribute 类型应为 RuleBasedTransactionAttribute");
        RuleBasedTransactionAttribute ruleBasedTx = (RuleBasedTransactionAttribute) requiredTx;
        assertTrue(ruleBasedTx.isReadOnly(), "add* 方法的 TransactionAttribute 应为只读事务");
        assertEquals(TransactionAttribute.PROPAGATION_REQUIRED, ruleBasedTx.getPropagationBehavior(), "add* 方法的 TransactionAttribute 的传播行为应为 PROPAGATION_REQUIRED");

        // 可以继续验证其他方法的 TransactionAttribute 设置

        TransactionAttribute readOnlyTx = methodMap.get("*");
        assertNotNull(readOnlyTx, "* 方法的 TransactionAttribute 不应为空");
        assertTrue(readOnlyTx instanceof RuleBasedTransactionAttribute, "* 方法的 TransactionAttribute 类型应为 RuleBasedTransactionAttribute");
        RuleBasedTransactionAttribute readOnlyRuleBasedTx = (RuleBasedTransactionAttribute) readOnlyTx;
        assertTrue(readOnlyRuleBasedTx.isReadOnly(), "* 方法的 TransactionAttribute 应为只读事务");
        assertEquals(TransactionAttribute.PROPAGATION_REQUIRED, readOnlyRuleBasedTx.getPropagationBehavior(), "* 方法的 TransactionAttribute 的传播行为应为 PROPAGATION_REQUIRED");
    }

    @Test
    @DisplayName("测试 txAdviceAdvisor 方法")
    public void testTxAdviceAdvisor() {
        Advisor txAdviceAdvisor = transactionManagerAdvice.txAdviceAdvisor();

        assertNotNull(txAdviceAdvisor, "返回值不应为空");

        // 验证 pointcut 表达式是否正确设置
//        assertTrue(txAdviceAdvisor.getPointcut() instanceof AspectJExpressionPointcut, "pointcut 类型应为 AspectJExpressionPointcut");
//        AspectJExpressionPointcut pointcut = (AspectJExpressionPointcut) txAdviceAdvisor.getPointcut();
//        assertEquals(TransactionManagerAdvice.AOP_POINTCUT_EXPRESSION, pointcut.getExpression(), "pointcut 表达式应为预期值");

        // 验证 advisor 的 txAdvice 是否正确设置
        assertTrue(txAdviceAdvisor.getAdvice() instanceof TransactionInterceptor, "txAdvice 类型应为 TransactionInterceptor");
        TransactionInterceptor txAdvice = (TransactionInterceptor) txAdviceAdvisor.getAdvice();
        assertNotNull(txAdvice.getTransactionManager(), "transactionManager 应该被正确设置");
        assertTrue(txAdvice.getTransactionAttributeSource() instanceof NameMatchTransactionAttributeSource, "TransactionAttributeSource 类型应为 NameMatchTransactionAttributeSource");
    }
}
