package com.alinesno.infra.common.web.adapter.enable;

import java.util.ArrayList;
import java.util.List;

import com.alinesno.infra.common.web.adapter.config.CORSProperites;
import com.alinesno.infra.common.web.adapter.config.CorsFilter;
import com.alinesno.infra.common.web.adapter.config.ServletConfig;
import com.alinesno.infra.common.web.adapter.config.WhiteListDefine;
import com.alinesno.infra.common.web.adapter.exception.GlobalExceptionHandler;
import com.alinesno.infra.common.web.adapter.plugins.AjaxResultResponseBodyAdvice;
import com.alinesno.infra.common.web.adapter.plugins.DatagridResponseBodyAdvice;

/**
 * 公共引用组件
 *
 * @author LuoAnDong
 * @since 2019年6月15日 下午9:29:14
 */
public class CommonApiImport {

	public static List<String> importCommonWeb() {

		List<String> importBean = new ArrayList<String>();

		importBean.add(CORSProperites.class.getName());
		importBean.add(CorsFilter.class.getName());
		importBean.add(ServletConfig.class.getName());

		// >>>>>>>>>>>> Http请求封装_start >>>>>>>>>>>>>>>>>
		importBean.add(WhiteListDefine.class.getName());
		// >>>>>>>>>>>> Http请求封装_end >>>>>>>>>>>>>>>>>
 
		importBean.add(GlobalExceptionHandler.class.getName());

		// 平台字段转换
		importBean.add(DatagridResponseBodyAdvice.class.getName());
		importBean.add(AjaxResultResponseBodyAdvice.class.getName());

		return importBean;
	}

}
