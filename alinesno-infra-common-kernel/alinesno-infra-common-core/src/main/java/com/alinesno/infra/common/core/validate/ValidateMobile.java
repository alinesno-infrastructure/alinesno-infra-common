package com.alinesno.infra.common.core.validate;

import cn.hutool.core.util.PhoneUtil;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 验证手机号是否正确
 * 
 * @author luoxiaodong
 * @since 2022年3月5日 下午10:23:43
 */
public class ValidateMobile implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isNotBlank(value)) { // 验证手机号是否正确
			return PhoneUtil.isMobile(value);
		}
		return false;
	}

	@Override
	public void initialize(Phone constraintAnnotation) {

	}

}
