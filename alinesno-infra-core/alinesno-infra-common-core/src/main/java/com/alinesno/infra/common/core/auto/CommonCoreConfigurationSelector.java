package com.alinesno.infra.common.core.auto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.type.AnnotationMetadata;

import com.alinesno.infra.common.core.auto.constom.CustomAutoConfigurationImportSelector;

/**
 * 引入自动类
 * 
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public class CommonCoreConfigurationSelector extends CustomAutoConfigurationImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		List<String> importBean = new ArrayList<String>();

		// common core
		List<String> coreLoader = CoreImportProvider.classLoader();
		importBean.addAll(coreLoader);

		return importBean.toArray(new String[] {});
	}

	@Override
	protected Class<?> getAnnotationClass() {
		return EnableCore.class;
	}

}
