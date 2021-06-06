package com.wangwei.javase.thread.threedlocal;

/**
 * @Author wangwei
 * @Date 2020/3/30 8:03 上午
 * @Version 1.0
 */
public class Channel {
    private Channel(){}
    public static Message message;
    public static void setMessage(Message m) {
        message = m;
    }
    public static void send() {   //发送消息
        System.out.println("【消息发送】" + message.getInfo());
    }   //【消息发送】www.mldn.cn
}
