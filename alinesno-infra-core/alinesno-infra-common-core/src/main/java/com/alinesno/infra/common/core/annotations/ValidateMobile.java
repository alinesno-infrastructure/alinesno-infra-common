package com.alinesno.infra.common.core.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

import cn.hutool.core.util.PhoneUtil;

/**
 * 验证手机号是否正确
 * @author LuoAnDong
 * @since 2022年3月5日 下午10:23:43
 */
public class ValidateMobile implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isNotBlank(value)) { // 验证手机号是否正确
			return PhoneUtil.isMobile(value) ; 
		}
		return false;
	}

	@Override
	public void initialize(Phone constraintAnnotation) {
		
	}

}
