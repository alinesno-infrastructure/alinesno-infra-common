package com.alinesno.infra.common.config.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 基础的文件配置 web: file: mapping-path: /upload-files local-path:
 * ${user.home}/guinsoft-upload-files
 * 
 * 
 * @author LuoAnDong
 * @date 2018年12月22日 上午11:47:46
 */
@ConfigurationProperties(prefix = "web.file")
public class WebFileConfig {

	private String mappingPath;
	private String localPath;

	public String getMappingPath() {
		return mappingPath;
	}

	public void setMappingPath(String mappingPath) {
		this.mappingPath = mappingPath;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

}
