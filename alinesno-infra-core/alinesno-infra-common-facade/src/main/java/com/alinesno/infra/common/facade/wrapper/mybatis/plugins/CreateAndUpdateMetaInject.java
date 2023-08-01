package com.alinesno.infra.common.facade.wrapper.mybatis.plugins;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alinesno.infra.common.facade.account.CurrentAccountBean;
import com.alinesno.infra.common.facade.account.CurrentAccountHandle;
import com.alinesno.infra.common.facade.exception.ServiceException;
import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpStatus;

/**
 * MyBaits-Plus 时间和更新对比
 * 
 * @author LuoAnDong
 * @date 2023年7月21日 06:43:10
 */
public class CreateAndUpdateMetaInject implements MetaObjectHandler {

	private static final Logger log = LoggerFactory.getLogger(CreateAndUpdateMetaInject.class);

	@Override
	public void insertFill(MetaObject metaObject) {
		try {
			if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
				BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();

				Date current = ObjectUtil.isNotNull(baseEntity.getAddTime()) ? baseEntity.getAddTime() : new Date();

				baseEntity.setAddTime(current);
				baseEntity.setUpdateTime(current);

				String username = StringUtils.isNotBlank(baseEntity.getOperatorId()) ? baseEntity.getOperatorId()
						: getLoginUsername();

				// 当前已登录 且 创建人为空 则填充
				baseEntity.setOperatorId(username);

				// 当前已登录 且 更新人为空 则填充
				baseEntity.setLastUpdateOperatorId(username);
			}
		} catch (Exception e) {
			throw new ServiceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		try {
			if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {

				BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
				Date current = new Date();

				// 更新时间填充(不管为不为空)
				baseEntity.setUpdateTime(current);
				String username = getLoginUsername();
				// 当前已登录 更新人填充(不管为不为空)
				if (StringUtils.isNotBlank(username)) {
					baseEntity.setLastUpdateOperatorId(username);
				}
			}
		} catch (Exception e) {
			throw new ServiceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
		}
	}

	/**
	 * 获取登录用户名
	 */
	private String getLoginUsername() {
		CurrentAccountBean loginUser;
		try {
			loginUser = CurrentAccountHandle.getCurrentAccount();
		} catch (Exception e) {
			log.warn("自动注入警告 => 用户未登录");
			return null;
		}
		return ObjectUtil.isNotNull(loginUser) ? loginUser.getLoginName() : null;
	}

}
