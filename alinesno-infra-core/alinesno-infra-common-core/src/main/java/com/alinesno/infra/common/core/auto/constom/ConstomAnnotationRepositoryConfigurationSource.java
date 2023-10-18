package com.alinesno.infra.common.core.auto.constom;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
import org.springframework.data.util.Streamable;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstomAnnotationRepositoryConfigurationSource extends AnnotationRepositoryConfigurationSource {

	private String BASE_JPA_PACKAGES = "jpa";
	private String[] businessBackPackage;

	@Override
	public Streamable<String> getBasePackages() {

		String[] basePackages = this.getAttributes().getStringArray(BASE_JPA_PACKAGES);

		Set<String> packages = new HashSet<>();
		packages.addAll(Arrays.asList(basePackages));
		packages.addAll(Arrays.asList(this.getBusinessBackPackage()));

		return Streamable.of(packages);
	}

	@SuppressWarnings("deprecation")
	public ConstomAnnotationRepositoryConfigurationSource(AnnotationMetadata metadata,
			Class<? extends Annotation> annotation, ResourceLoader resourceLoader, Environment environment,
			BeanDefinitionRegistry registry, String[] businessBackPackage) {
		super(metadata, annotation, resourceLoader, environment, registry);
		this.setBusinessBackPackage(businessBackPackage);
	}

	public String[] getBusinessBackPackage() {
		return businessBackPackage;
	}

	public void setBusinessBackPackage(String[] businessBackPackage) {
		this.businessBackPackage = businessBackPackage;
	}

}
