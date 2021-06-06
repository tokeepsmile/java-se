package com.wangwei.javase.thread.threedlocal;

/**
 * @Author wangwei
 * @Date 2020/3/30 8:13 上午
 * @Version 1.0
 */
public class ChannelForThreadSync {
    private ChannelForThreadSync(){};
    private static final ThreadLocal<Message> THREADLOCAL=new ThreadLocal<>();
    public static void setMessage(Message m) {
        THREADLOCAL.set(m);    //向ThreadLocal中保存数据
    }
    public static void send() {  //发送消息
        System.out.println("【"+Thread.currentThread().getName()+"、消息发送】" + THREADLOCAL.get().getInfo());
    }
}
