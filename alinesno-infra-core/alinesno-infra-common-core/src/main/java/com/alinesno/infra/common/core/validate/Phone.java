package com.alinesno.infra.common.core.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Null;
import java.lang.annotation.*;

/**
 * 
 * 验证手机号，空和正确的手机号都能验证通过<br/>
 * 正确的手机号由11位数字组成，第一位为1 第二位为 3、4、5、7、8
 * 
 * @author luoxiaodong
 * @since 2019年9月18日 下午9:13:27
 */
@Null
@Documented
@Constraint(validatedBy = ValidateMobile.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
		ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface Phone {
	String message() default "手机号错误";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}