package javax.lang.exception;

/**
 * 多数情况下，创建自定义异常需要继承Exception，本例继承Exception的子类RuntimeException,放在javax或者java目录下面,dubbo不做拦截
 * 
 * @author luoxiaodong
 * @since 2019年9月17日 下午9:18:23
 */
@SuppressWarnings("serial")
public class RpcWebException extends RuntimeException {

	private String code; // 异常对应的返回码
	private String message; // 异常对应的描述信息
	private String threadInfo;

	public RpcWebException() {
		super();
	}

	protected RpcWebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RpcWebException(String message) {
		super(message);
		this.message = message;
	}

	public RpcWebException(String message, String threadInfo, Throwable cause) {
		super(message, cause);
		this.threadInfo = threadInfo;
	}

	public RpcWebException(Throwable cause) {
		super(cause);
	}

	public RpcWebException(String retCd, String msgDes) {
		super();
		this.code = retCd;
		this.message = msgDes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getThreadInfo() {
		return threadInfo;
	}

	public void setThreadInfo(String threadInfo) {
		this.threadInfo = threadInfo;
	}

	public static RpcWebException error(String e) {
		return new RpcWebException(e);
	}

	public static void e(String e) {
		new RpcWebException(e);
	}
}
