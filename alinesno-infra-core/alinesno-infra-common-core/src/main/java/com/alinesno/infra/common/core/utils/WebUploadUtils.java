package com.alinesno.infra.common.core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import cn.hutool.core.lang.UUID;

/**
 * 文件上传工具对象，用于单体应用的，内置的简单文件上传功能
 * 
 * @author WeiXiaoJin
 * @since 2019年4月11日 上午8:42:51
 */
@Component
public class WebUploadUtils {

	private static final Logger log = LoggerFactory.getLogger(WebUploadUtils.class);

	@Value("${storage.web.local.upload-path:user.home}")
	private String logFileTmp; // 本地文件

	/**
	 * 保存到本地临时目录
	 * 
	 * @param file
	 * @param fileName
	 * @return
	 */
	public String storageFile(MultipartFile file, String fileName) {
		try {
			String localPath = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
			String tempFolder = logFileTmp + File.separator + localPath;
			File f = new File(tempFolder);
			if (!f.exists()) {
				FileUtils.forceMkdir(new File(tempFolder));
			}

			String newFilename = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));

			log.debug("上传目录:{} , file.getOriginalFilename():{}", tempFolder, file.getOriginalFilename());
			Path path = Paths.get(tempFolder + File.separator + newFilename);

			FileUtils.copyInputStreamToFile(file.getInputStream(), path.toFile());

			log.debug("path = {}", path.toFile().getAbsolutePath());
			return path.toFile().getAbsolutePath();
		} catch (IOException e) {
			log.error("图片上传错误:{}", e);
		}

		return null;
	}

	/**
	 * 文件传输
	 * 
	 * @param cloudUrl
	 * @param file
	 * @return
	 */
	public static String transferFile(String cloudUrl, File file, String suffix, String userId, String userName,
			String applicationName) {
		RestTemplate restTemplate = new RestTemplate();

		// 设置请求头
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("multipart/form-data");
		headers.setContentType(type);

		// 设置请求体，注意是LinkedMultiValueMap
		FileSystemResource fileSystemResource = new FileSystemResource(file);
		MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
		form.add("file", fileSystemResource);
		form.add("filename", file.getName());
		form.add("suffix", suffix);
		form.add("applicationName", applicationName);

		form.add("userId", userId);
		form.add("userName", userName);

		// 用HttpEntity封装整个请求报文
		HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);
		String s = restTemplate.postForObject(cloudUrl, files, String.class);

		return s;
	}
}