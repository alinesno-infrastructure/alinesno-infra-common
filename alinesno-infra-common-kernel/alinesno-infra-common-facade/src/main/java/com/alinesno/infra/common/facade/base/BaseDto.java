package com.alinesno.infra.common.facade.base;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
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
public class BaseDto extends InfraBaseEntity {

    //参数签名 非空
    private String sign;

    //对称加密key 非空
    private String aseKey;

    //时间戳，精确到毫秒 非空
    private long timestamp;

}
