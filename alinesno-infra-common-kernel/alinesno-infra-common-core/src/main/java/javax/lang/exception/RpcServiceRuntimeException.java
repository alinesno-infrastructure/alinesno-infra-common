package javax.lang.exception;

import lombok.Getter;

/**
 * 多数情况下，创建自定义异常需要继承Exception，本例继承Exception的子类RuntimeException,放在javax或者java目录下面,dubbo不做拦截
 * 
 * @author luoxiaodong
 * @since 2019年9月17日 下午9:18:23
 */
@Getter
public class RpcServiceRuntimeException extends RuntimeException {

	private String code; // 异常对应的返回码
	private String message; // 异常对应的描述信息
	private String threadInfo;

	public RpcServiceRuntimeException() {
		super();
	}

	protected RpcServiceRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RpcServiceRuntimeException(String message) {
		super(message);
		this.message = message;
	}

	public RpcServiceRuntimeException(String message, String threadInfo, Throwable cause) {
		super(message, cause);
		this.threadInfo = threadInfo;
	}

	public RpcServiceRuntimeException(Throwable cause) {
		super(cause);
	}

	public RpcServiceRuntimeException(String retCd, String msgDes) {
		super();
		this.code = retCd;
		this.message = msgDes;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setThreadInfo(String threadInfo) {
		this.threadInfo = threadInfo;
	}

	public static RpcServiceRuntimeException error(String e) {
		return new RpcServiceRuntimeException(e);
	}

	public static void e(String e) {
		new RpcServiceRuntimeException(e);
	}
}
