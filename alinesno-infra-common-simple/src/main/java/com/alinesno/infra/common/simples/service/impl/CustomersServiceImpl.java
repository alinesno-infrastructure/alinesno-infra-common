package com.alinesno.infra.common.simples.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.simples.entity.CustomersEntity;
import com.alinesno.infra.common.simples.mapper.CustomersMapper;
import com.alinesno.infra.common.simples.service.ICustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户Service实现类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Service
public class CustomersServiceImpl extends IBaseServiceImpl<CustomersEntity, CustomersMapper> implements ICustomersService {
    private static final Logger log = LoggerFactory.getLogger(CustomersServiceImpl.class);
}
