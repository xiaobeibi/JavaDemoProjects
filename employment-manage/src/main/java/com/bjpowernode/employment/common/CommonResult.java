package com.bjpowernode.employment.common;

/**
 * 通用返回格式，使用泛型兼容 layui table
 *
 * */
public class CommonResult<T> {

    private long code;//状态码
    private String msg;//消息
    private long count;//返回数据的数量
    private T data;//数据

    private CommonResult(){};
    private CommonResult(long code, String msg, long count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    /**
     * 静态工厂方法构造成功的CommonResult
     * @param count 数量
     * @param data 数据
     * */
    public static <T> CommonResult<T> generateSuccessResult(long count, T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), count, data);
    }

    /**
     * 静态工厂方法构造成功的CommonResult，自定义消息
     * @param msg 成功提示信息
     * @param count 数量
     * @param data 数据
     * */
    public static <T> CommonResult<T> generateSuccessResult(String msg, long count, T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), msg, count, data);
    }

    /**
     * 静态工厂方法构造失败的CommonResult
     * @param count 数量
     * @param data 数据
     * */
    public static <T> CommonResult<T> generateFailureResult(long count, T data){
        return new CommonResult<T>(ResultCode.FAILURE.getCode(), ResultCode.FAILURE.getMsg(), 0, null);
    }

    /**
     * 静态工厂方法构造失败的CommonResult，自定义消息
     * @param msg 成功提示信息
     * @param count 数量
     * @param data 数据
     * */
    public static <T> CommonResult<T> generateFailureResult(String msg, long count, T data){
        return new CommonResult<T>(ResultCode.FAILURE.getCode(), msg, 0, null);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
