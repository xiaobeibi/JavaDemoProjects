package com.power.travel.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 * 200 和 5000 需要自行处理错误，
 * 其他的通过ajax全局设置处理
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 失败
     */
    FAIL(400),
    /**
     * 绑定错误
     */
    BIND_FAIL(417),
    /**
     * 接口不存在
     */
    NOT_FOUND(404),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500),
    /**
     * 需执行处理
     */
    DATA_ERROR(5000);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
