package com.bjpowernode.employment.common;

/**
 * 状态码枚举类
 *
 * */
public enum ResultCode {

    SUCCESS(0, "成功"),//成功的实例，为了兼容layui table 写成0，最好是200
    FAILURE(500, "失败");//失败的实例

    private long code;
    private String msg;

    //枚举类必须先定义枚举实例在定义方法，且构造函数必须私有
    ResultCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
