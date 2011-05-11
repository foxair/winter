package com.gm.common.exception;

/**
 * 自定义改进的Exception对象 覆写了 fillInStackTrace方法 1. 不填充stack 2. 取消同步
 */
public abstract class BaseSysExecption extends Exception implements SysExecption {

	protected String errorCode;
	protected String errorMessage;

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

	public String getMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public BaseSysExecption() {
		super();
	}

	public BaseSysExecption(String message) {
		super(message);
	}

	public BaseSysExecption(Throwable cause) {
		super(cause);
	}

	public BaseSysExecption(String message, Throwable cause) {
		super(message, cause);
	}
}