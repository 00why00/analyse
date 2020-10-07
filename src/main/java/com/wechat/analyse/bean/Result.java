package com.wechat.analyse.bean;

/**
 * 向前端返回信息的封装{msg:"注册成功",detail:""}
 * @param <T>
 */
public class Result<T> {
    private String msg;
    private boolean success;
    private T detail;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
