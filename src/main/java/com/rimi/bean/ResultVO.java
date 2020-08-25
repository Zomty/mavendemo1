package com.rimi.bean;

public class ResultVO {
    private int code;  // 状态码  0表示验证码异常  1表示成功   2表示用户账号密码错误
    private String msg; //
    private int count;  // 数据的行数
    private Object data; // 请求成功的数据

    public ResultVO() {
    }

    public ResultVO(int code, String msg, int count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
