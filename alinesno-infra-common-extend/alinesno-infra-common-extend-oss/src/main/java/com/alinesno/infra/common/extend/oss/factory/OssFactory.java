package com.alinesno.infra.common.extend.oss.factory;

import com.alinesno.infra.common.core.cache.RedisUtils;
import com.alinesno.infra.common.core.utils.JsonUtils;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.extend.oss.cache.OssCacheUtils;
import com.alinesno.infra.common.extend.oss.constant.OssConstant;
import com.alinesno.infra.common.extend.oss.core.OssClient;
import com.alinesno.infra.common.extend.oss.exception.OssException;
import com.alinesno.infra.common.extend.oss.properties.OssProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 文件上传Factory
 *
 * @author Lion Li
 */
@Slf4j
public class OssFactory {

    private static final Map<String, OssClient> CLIENT_CACHE = new ConcurrentHashMap<>();

    /**
     * 获取默认实例
     */
    public static OssClient instance() {
        // 获取redis 默认类型
        String configKey = RedisUtils.getCacheObject(OssConstant.DEFAULT_CONFIG_KEY);
        if (StringUtils.isEmpty(configKey)) {
            throw new OssException("文件存储服务类型无法找到!");
        }
        return instance(configKey);
    }

    /**
     * 根据类型获取实例
     */
    public static synchronized OssClient instance(String configKey) {
        String json = OssCacheUtils.get(OssConstant.SYS_OSS_CONFIG, configKey);
        if (json == null) {
            throw new OssException("系统异常, '" + configKey + "'配置信息不存在!");
        }
        OssProperties properties = JsonUtils.parseObject(json, OssProperties.class);
        // 使用租户标识避免多个租户相同key实例覆盖
        String key = properties.getTenantId() + ":" + configKey;
        OssClient client = CLIENT_CACHE.get(key);
        if (client == null) {
            CLIENT_CACHE.put(key, new OssClient(configKey, properties));
            log.info("创建OSS实例 key => {}", configKey);
            return CLIENT_CACHE.get(key);
        }
        // 配置不相同则重新构建
        if (!client.checkPropertiesSame(properties)) {
            CLIENT_CACHE.put(key, new OssClient(configKey, properties));
            log.info("重载OSS实例 key => {}", configKey);
            return CLIENT_CACHE.get(key);
        }
        return client;
    }

}
