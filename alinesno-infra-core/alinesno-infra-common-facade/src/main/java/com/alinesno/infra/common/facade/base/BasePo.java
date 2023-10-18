package com.alinesno.infra.common.facade.base;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体对象基类,定义基本属性
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BasePo extends BaseEntity {

}
