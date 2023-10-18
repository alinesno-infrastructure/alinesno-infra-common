package com.alinesno.infra.common.core.auto;

import com.alinesno.infra.common.core.auto.constom.CustomAutoConfigurationImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 引入自动类
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class CommonCoreConfigurationSelector extends CustomAutoConfigurationImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // common core
		List<String> coreLoader = CoreImportProvider.classLoader();
        List<String> importBean = new ArrayList<>(coreLoader);

		return importBean.toArray(new String[] {});
	}

	@Override
	protected Class<?> getAnnotationClass() {
		return EnableCore.class;
	}

}
