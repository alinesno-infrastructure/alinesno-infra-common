package com.alinesno.infra.common.core.auto.constom;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
import org.springframework.data.repository.config.RepositoryConfigurationDelegate;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;
import org.springframework.data.repository.config.RepositoryConfigurationUtils;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;

public abstract class ConstomRepositoryDefinitionRegistrar
		implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware, BaseConstomBusinessAuto {

	private ResourceLoader resourceLoader;
	private Environment environment;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {

		Assert.notNull(annotationMetadata, "AnnotationMetadata must not be null!");
		Assert.notNull(registry, "BeanDefinitionRegistry must not be null!");
		Assert.notNull(resourceLoader, "ResourceLoader must not be null!");

		if (annotationMetadata.getAnnotationAttributes(getAnnotation().getName()) == null) {
			return;
		}

		AnnotationRepositoryConfigurationSource configurationSource = new ConstomAnnotationRepositoryConfigurationSource(
				annotationMetadata, getAnnotation(), resourceLoader, environment, registry,
				this.getBusinessBackPackage());

		RepositoryConfigurationExtension extension = getExtension();
		RepositoryConfigurationUtils.exposeRegistration(extension, registry, configurationSource);

		RepositoryConfigurationDelegate delegate = new RepositoryConfigurationDelegate(configurationSource,
				resourceLoader, environment);

		delegate.registerRepositoriesIn(registry, extension);
	}

	protected abstract Class<? extends Annotation> getAnnotation();

	protected RepositoryConfigurationExtension getExtension() {
//		return new JpaRepositoryConfigExtension();
		return null;
	};

}
