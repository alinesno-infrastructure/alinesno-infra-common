package com.alinesno.infra.common.web.adapter.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.alinesno.infra.common.core.utils.DateUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 文件处理工具类
 * 
 * @author ruoyi
 */
public class FileUtils {
	public static String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";

	/**
	 * 输出指定文件的byte数组
	 * 
	 * @param filePath 文件路径
	 * @param os       输出流
	 * @return
	 */
	public static void writeBytes(String filePath, OutputStream os) throws IOException {
		FileInputStream fis = null;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException(filePath);
			}
			fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			int length;
			while ((length = fis.read(b)) > 0) {
				os.write(b, 0, length);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			IOUtils.closeQuietly(os);
			IOUtils.closeQuietly(fis);
		}
	}

	/**
	 * 写数据到文件中
	 *
	 * @param data      数据
	 * @param uploadDir 目标文件
	 * @return 目标文件
	 * @throws IOException IO异常
	 */
	public static String writeBytes(byte[] data, String uploadDir) throws IOException {
		FileOutputStream fos = null;
		String pathName = "";
		try {
			String extension = getFileExtendName(data);
			pathName = DateUtils.datePath() + "/" + IdWorker.get32UUID() + "." + extension;
			File file = FileUploadUtils.getAbsoluteFile(uploadDir, pathName);
			fos = new FileOutputStream(file);
			fos.write(data);
		} finally {
			IOUtils.closeQuietly(fos);
		}
		return FileUploadUtils.getPathFileName(uploadDir, pathName);
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath 文件
	 * @return
	 */
	public static boolean deleteFile(String filePath) {
		boolean flag = false;
		File file = new File(filePath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 文件名称验证
	 * 
	 * @param filename 文件名称
	 * @return true 正常 false 非法
	 */
	public static boolean isValidFilename(String filename) {
		return filename.matches(FILENAME_PATTERN);
	}

	/**
	 * 检查文件是否可下载
	 * 
	 * @param resource 需要下载的文件
	 * @return true 正常 false 非法
	 */
	public static boolean checkAllowDownload(String resource) {
		// 禁止目录上跳级别
		if (StringUtils.contains(resource, "..")) {
			return false;
		}

		// 检查允许下载的文件规则
		if (ArrayUtils.contains(MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION, FileTypeUtils.getFileType(resource))) {
			return true;
		}

		// 不在允许下载的文件规则
		return false;
	}

	/**
	 * 下载文件名重新编码
	 * 
	 * @param request  请求对象
	 * @param fileName 文件名
	 * @return 编码后的文件名
	 */
	public static String setFileDownloadHeader(HttpServletRequest request, String fileName)
			throws UnsupportedEncodingException {
		final String agent = request.getHeader("USER-AGENT");
		String filename = fileName;
		if (agent.contains("MSIE")) {
			// IE浏览器
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// 火狐浏览器
			filename = new String(fileName.getBytes(), "ISO8859-1");
		} else if (agent.contains("Chrome")) {
			// google浏览器
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			// 其它浏览器
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}

	/**
	 * 下载文件名重新编码
	 *
	 * @param response     响应对象
	 * @param realFileName 真实文件名
	 * @return
	 */
	public static void setAttachmentResponseHeader(HttpServletResponse response, String realFileName)
			throws UnsupportedEncodingException {
		String percentEncodedFileName = percentEncode(realFileName);

		StringBuilder contentDispositionValue = new StringBuilder();
		contentDispositionValue.append("attachment; filename=").append(percentEncodedFileName).append(";")
				.append("filename*=").append("utf-8''").append(percentEncodedFileName);

		response.setHeader("Content-disposition", contentDispositionValue.toString());
	}

	/**
	 * 百分号编码工具方法
	 *
	 * @param s 需要百分号编码的字符串
	 * @return 百分号编码后的字符串
	 */
	public static String percentEncode(String s) throws UnsupportedEncodingException {
		String encode = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
		return encode.replaceAll("\\+", "%20");
	}

	/**
	 * 获取图像后缀
	 * 
	 * @param photoByte 图像数据
	 * @return 后缀名
	 */
	public static String getFileExtendName(byte[] photoByte) {
		String strFileExtendName = "jpg";
		if ((photoByte[0] == 71) && (photoByte[1] == 73) && (photoByte[2] == 70) && (photoByte[3] == 56)
				&& ((photoByte[4] == 55) || (photoByte[4] == 57)) && (photoByte[5] == 97)) {
			strFileExtendName = "gif";
		} else if ((photoByte[6] == 74) && (photoByte[7] == 70) && (photoByte[8] == 73) && (photoByte[9] == 70)) {
			strFileExtendName = "jpg";
		} else if ((photoByte[0] == 66) && (photoByte[1] == 77)) {
			strFileExtendName = "bmp";
		} else if ((photoByte[1] == 80) && (photoByte[2] == 78) && (photoByte[3] == 71)) {
			strFileExtendName = "png";
		}
		return strFileExtendName;
	}
}
