package com.bjpowernode.pan.model;

/**
 * 给前台返回的操作结果
 *
 */
public class ResponseMsg {
    private boolean success;

    private String msg;

    /**
     * 无参构造函数默认失败
     */
    public ResponseMsg() {
        this.success = false;
        this.msg = "";
    }

    public ResponseMsg(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    /**
     * 填入信息默认成功
     * @param msg msg
     */
    public ResponseMsg(String msg) {
        this.success = true;
        this.msg = msg;
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
}
