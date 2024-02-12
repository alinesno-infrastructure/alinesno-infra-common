package com.alinesno.infra.common.web.adapter.exception.file;

import lombok.Getter;

import java.util.Arrays;

/**
 * 文件上传 误异常类
 * 
 * @author ruoyi
 * @author luoxiaodong
 *
 */
@Getter
public class InvalidExtensionException extends FileUploadException {

	private final String[] allowedExtension;
	private final String extension;
	private final String filename;

	public InvalidExtensionException(String[] allowedExtension, String extension, String filename) {
		super("filename : [" + filename + "], extension : [" + extension + "], allowed extension : ["
				+ Arrays.toString(allowedExtension) + "]");
		this.allowedExtension = allowedExtension;
		this.extension = extension;
		this.filename = filename;
	}

	public static class InvalidImageExtensionException extends InvalidExtensionException {

		public InvalidImageExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidFlashExtensionException extends InvalidExtensionException {

		public InvalidFlashExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidMediaExtensionException extends InvalidExtensionException {

		public InvalidMediaExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidVideoExtensionException extends InvalidExtensionException {

		public InvalidVideoExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}
}
