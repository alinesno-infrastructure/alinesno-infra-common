package com.alinesno.infra.common.web.adapter.sso.enable;

import com.alinesno.infra.common.web.adapter.sso.controller.SsoClientController;
import com.alinesno.infra.common.web.adapter.sso.controller.SsoH5Controller;
import com.alinesno.infra.common.web.adapter.sso.listener.SaTokenListener;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 引入自动类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
public class SsoApiConfigurationSelector implements ImportSelector {

	@NotNull
	@Override
	public String[] selectImports(@NotNull AnnotationMetadata importingClassMetadata) {

        List<String> importBean = new ArrayList<>();

		importBean.add(SsoH5Controller.class.getName()) ;
		importBean.add(SsoClientController.class.getName()) ;
		importBean.add(SaTokenListener.class.getName()) ;

		return importBean.toArray(new String[] {});
	}

}
