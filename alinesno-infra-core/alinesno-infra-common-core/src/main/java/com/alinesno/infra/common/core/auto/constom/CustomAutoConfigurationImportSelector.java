package com.alinesno.infra.common.core.auto.constom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

/**
 * 自定义基础引入类实现
 * 
 * @author WeiXiaoJin
 * @since 2019年9月22日 下午1:51:14
 */
public abstract class CustomAutoConfigurationImportSelector implements ImportSelector, BeanClassLoaderAware,
		ResourceLoaderAware, BeanFactoryAware, EnvironmentAware, Ordered {

	private static final Logger log = LoggerFactory.getLogger(CustomAutoConfigurationImportSelector.class);

	private static final String PROPERTY_NAME_AUTOCONFIGURE_EXCLUDE = "spring.autoconfigure.exclude";

	@SuppressWarnings("unused")
	private ConfigurableListableBeanFactory beanFactory;

	private Environment environment;

	private ClassLoader beanClassLoader;

	private ResourceLoader resourceLoader;

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.beanClassLoader = classLoader;
	}

	protected ClassLoader getBeanClassLoader() {
		return this.beanClassLoader;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	protected final Environment getEnvironment() {
		return this.environment;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	protected final ResourceLoader getResourceLoader() {
		return this.resourceLoader;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		Assert.isInstanceOf(ConfigurableListableBeanFactory.class, beanFactory);
		this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE - 1;
	}

	@Override
	public abstract String[] selectImports(AnnotationMetadata importingClassMetadata);

	/**
	 * 获取到所有属性
	 * 
	 * @param metadata
	 * @return
	 */
	protected AnnotationAttributes getAttributes(AnnotationMetadata metadata) {
		String name = getAnnotationClass().getName();
		AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(name, true));
		Assert.notNull(attributes, () -> "No auto-configuration attributes found. Is " + metadata.getClassName()
				+ " annotated with " + ClassUtils.getShortName(name) + "?");
		return attributes;
	}

	/**
	 * 获取到注解类型
	 * 
	 * @return
	 */
	protected abstract Class<?> getAnnotationClass();

	/**
	 * 构造Class扫描器，分两类，一类是扫实体，即为本地工程的时候，另一类是招dubbo服务，即只扫接口
	 */
	protected ClassPathScanningCandidateComponentProvider getScanner(boolean dubbo) {
		if (dubbo) {
			return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
				@Override
				protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
					if (beanDefinition.getMetadata().isInterface()) {
						return true;
					}
					return false;
				}
			};
		} else {
			ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
					true);
			return provider;
		}
	}

	protected ClassPathScanningCandidateComponentProvider getScanner() {
		return this.getScanner(false);
	}

	/**
	 * 未引入的数据
	 * 
	 * @param metadata
	 * @param attributes
	 * @return
	 */
	protected Set<String> getExclusions(AnnotationMetadata metadata, AnnotationAttributes attributes) {
		Set<String> excluded = new LinkedHashSet<>();
		excluded.addAll(asList(attributes, "exclude"));
		excluded.addAll(Arrays.asList(attributes.getStringArray("excludeName")));
		excluded.addAll(getExcludeAutoConfigurationsProperty());

		for (String c : excluded) {
			log.debug("去掉不需要引入的对象 class:{}", c);
		}

		return excluded;
	}

	/**
	 * 获取扫描类实现
	 * 
	 * @return
	 */
	protected List<String> scanPackage(String basePackage) {
		// 获取Class的扫描器
		ClassPathScanningCandidateComponentProvider scanner = getScanner();
		scanner.setResourceLoader(this.getResourceLoader());

		log.info("basePackage:{}", basePackage);

		// 获取基础包底下所有符合条件的类的定义
		Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
		List<String> importBean = new ArrayList<String>();

		for (BeanDefinition candidateComponent : candidateComponents) {
			log.info("candidateComponent:{}", candidateComponent);
			importBean.add(candidateComponent.getBeanClassName());
		}
		return importBean; // StringUtils.toStringArray(importBean) ;
	}

	/**
	 * 获取扫描类实现
	 * 
	 * @return
	 */
	protected List<String> scanComponent(String pkg) {
		// 获取Class的扫描器
		ClassPathScanningCandidateComponentProvider scanner = getScanner();
		scanner.setResourceLoader(this.getResourceLoader());

		// 指定扫描的基础包
		String basePackage = ClassUtils.getPackageName(this.getAnnotationClass()); // importingClassMetadata.getClassName());

		log.info("basePackage:{}", basePackage);

		// 获取基础包底下所有符合条件的类的定义
		Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
		List<String> importBean = new ArrayList<String>();

		for (BeanDefinition candidateComponent : candidateComponents) {
			log.info("candidateComponent:{}", candidateComponent);
			importBean.add(candidateComponent.getBeanClassName());
		}
		return importBean; // StringUtils.toStringArray(importBean) ;
	}

	private List<String> getExcludeAutoConfigurationsProperty() {
		if (getEnvironment() instanceof ConfigurableEnvironment) {
			Binder binder = Binder.get(getEnvironment());
			return binder.bind(PROPERTY_NAME_AUTOCONFIGURE_EXCLUDE, String[].class).map(Arrays::asList)
					.orElse(Collections.emptyList());
		}
		String[] excludes = getEnvironment().getProperty(PROPERTY_NAME_AUTOCONFIGURE_EXCLUDE, String[].class);
		return (excludes != null) ? Arrays.asList(excludes) : Collections.emptyList();
	}

	protected final <T> List<T> removeDuplicates(List<T> list) {
		return new ArrayList<>(new LinkedHashSet<>(list));
	}

	protected final List<String> asList(AnnotationAttributes attributes, String name) {
		String[] value = attributes.getStringArray(name);
		return Arrays.asList((value != null) ? value : new String[0]);
	}

}
