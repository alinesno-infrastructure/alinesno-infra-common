package com.alinesno.infra.common.simples.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.simples.entity.ProductsEntity;
import com.alinesno.infra.common.simples.mapper.ProductsMapper;
import com.alinesno.infra.common.simples.service.IProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 产品Service业务层处理
 *
 * @version 1.0.0
 * @author luoandong
 */
@Service
public class ProductsServiceImpl extends IBaseServiceImpl<ProductsEntity, ProductsMapper> implements IProductsService {
    // 日志记录
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(ProductsServiceImpl.class);
}
