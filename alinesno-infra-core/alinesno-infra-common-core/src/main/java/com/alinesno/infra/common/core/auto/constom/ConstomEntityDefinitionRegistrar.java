package com.alinesno.infra.common.core.auto.constom;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.domain.EntityScanPackages;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * 实体扫描器
 * 
 * @author WeiXiaoJin
 * @since 2020年2月29日 下午12:38:06
 */
public abstract class ConstomEntityDefinitionRegistrar
		implements ImportBeanDefinitionRegistrar, BaseConstomBusinessAuto {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		EntityScanPackages.register(registry, getPackagesToScan(metadata));
	}

	private Set<String> getPackagesToScan(AnnotationMetadata metadata) {

		AnnotationAttributes attributes = AnnotationAttributes
				.fromMap(metadata.getAnnotationAttributes(this.getAnnotation().getName()));

		String[] basePackages = attributes.getStringArray("entity");

		Set<String> packagesToScan = new LinkedHashSet<>();
		packagesToScan.addAll(Arrays.asList(basePackages));
		packagesToScan.addAll(Arrays.asList(this.getBusinessBackPackage()));

		if (packagesToScan.isEmpty()) {
			String packageName = ClassUtils.getPackageName(metadata.getClassName());
			Assert.state(!StringUtils.hasLength(packageName), "@EntityScan cannot be used with the default package");
			return Collections.singleton(packageName);
		}

		return packagesToScan;
	}

	public abstract String[] getBusinessBackPackage();

	public abstract Class<? extends Annotation> getAnnotation();

}
