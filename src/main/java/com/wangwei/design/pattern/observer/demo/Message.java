package com.wangwei.design.pattern.observer.demo;

/**
 * @Author wangwei
 * @Date 2020/4/26 8:34 上午
 * @Version 1.0
 */
public class Message {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
