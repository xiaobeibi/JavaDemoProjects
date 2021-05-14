package com.power.travel.core;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfiguration
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 2987069302761521237L;

	public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
