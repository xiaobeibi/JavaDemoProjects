package com.bjpowernode.model;

/**
 *
 */
public class Result {

    /**
     * 成功状态
     */
    private boolean success = false;

    /**
     * 文本信息
     */
    private String msg = "";

    /**
     * 数据
     */
    private Object data = null;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
