// 公共字段
```sql
    id VARCHAR(64) NOT NULL COMMENT '主键',
    add_time DATETIME DEFAULT NULL COMMENT '添加时间',
    application_id VARCHAR(64) DEFAULT NULL COMMENT '所属应用',
    delete_manager VARCHAR(64) DEFAULT NULL COMMENT '删除人员',
    delete_time DATETIME DEFAULT NULL,
    department_id VARCHAR(64) DEFAULT NULL COMMENT '部门权限',
    field_id VARCHAR(64) DEFAULT NULL COMMENT '字段权限',
    field_prop VARCHAR(128) DEFAULT NULL COMMENT '字段属性',
    has_delete INT DEFAULT NULL COMMENT '是否删除',
    has_status INT DEFAULT NULL COMMENT '状态',
    last_update_operator_id VARCHAR(64) DEFAULT NULL COMMENT '最后更新操作员',
    operator_id VARCHAR(64) DEFAULT NULL COMMENT '操作员',
    tenant_id VARCHAR(64) DEFAULT NULL COMMENT '所属租户',
    update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
    application_name VARCHAR(64) DEFAULT NULL COMMENT '应用名称',
```