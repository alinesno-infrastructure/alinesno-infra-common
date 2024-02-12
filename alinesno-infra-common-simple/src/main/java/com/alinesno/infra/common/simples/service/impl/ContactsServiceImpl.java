package com.alinesno.infra.common.simples.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.simples.entity.ContactsEntity;
import com.alinesno.infra.common.simples.mapper.ContactsMapper;
import com.alinesno.infra.common.simples.service.IContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 联系人Service业务层处理
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Service
public class ContactsServiceImpl extends IBaseServiceImpl<ContactsEntity, ContactsMapper> implements IContactsService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(ContactsServiceImpl.class);
}
