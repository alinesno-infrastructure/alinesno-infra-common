package com.alinesno.infra.common.core.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
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
	boolean modifyHasStatus(@RequestParam("id") String id) {
		return feign.updateHasStatus(id);
	}

	@GetMapping("findAllByApplicationId")
	List<E> findAllByApplicationId(@RequestParam("applicationId") String applicationId) {
//		return feign.findAllByApplicationId(applicationId);
		return null;
	}

	@GetMapping("findAllByTenantId")
	List<E> findAllByTenantId(@RequestParam("tenantId") String tenantId) {
//		return feign.findAllByTenantId(tenantId);
		return null;
	}
}
