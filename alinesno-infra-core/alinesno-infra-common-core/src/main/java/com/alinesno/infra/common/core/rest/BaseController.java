package com.alinesno.infra.common.core.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * 对外rest接口基类
 *
 * @author WeiXiaoJin
 * @since 2018年11月21日 上午10:46:56
 */
public abstract class BaseController<E extends BaseEntity, S extends IBaseService<E>> extends SuperController {

	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected S feign;

	/**
	 * 更新实体状态
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("modifyHasStatus")
	protected boolean modifyHasStatus(@RequestParam("id") Long id) {
		return feign.updateHasStatus(id);
	}

	@GetMapping("findAllByApplicationId")
	protected List<E> findAllByApplicationId(@RequestParam("applicationId") String applicationId) { 
		return null;
	}

	@GetMapping("findAllByTenantId")
	protected List<E> findAllByTenantId(@RequestParam("tenantId") String tenantId) { 
		return null;
	}
	

	protected TableDataInfo toDataInfo(Model model, S feign, DatatablesPageBean page) { 
		return null;
	}

	public S getFeign() { 
		return feign;
	}
}
