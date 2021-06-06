package com.wangwei.javase.thread.threedlocal;

/**
 * @Author wangwei
 * @Date 2020/3/30 8:16 上午
 * @Version 1.0
 */
public class JavaAPIForThreadSync {
    public static void main(String[] args) throws Exception {
        new Thread(()->{
            Message msg=new Message();//实例化消息主体对象
            msg.setInfo("第一个线程的消息");//设置要发送的内容
            ChannelForThreadSync.setMessage(msg);//设置要发送的消息
            ChannelForThreadSync.send();//发送消息
        },"消息发送者A").start();
        new Thread(()->{
            Message msg=new Message();//实例化消息主体对象
            msg.setInfo("第二个线程的消息");//设置要发送的内容
            ChannelForThreadSync.setMessage(msg);//设置要发送的消息
            ChannelForThreadSync.send();//发送消息
        },"消息发送者B").start();
        new Thread(()->{
            Message msg=new Message();//实例化消息主体对象
            msg.setInfo("第三个线程的消息");//设置要发送的内容
            ChannelForThreadSync.setMessage(msg);//设置要发送的消息
            ChannelForThreadSync.send();//发送消息
        },"消息发送者C").start();
    }
}
