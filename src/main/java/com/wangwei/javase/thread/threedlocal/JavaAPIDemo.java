package com.wangwei.javase.thread.threedlocal;

/**
 * @Author wangwei
 * @Date 2020/3/30 8:03 上午
 * @Version 1.0
 */
public class JavaAPIDemo {
    public static void main(String[] args) throws Exception {
        Message msg=new Message();   //实例化消息主体对象
        msg.setInfo("www.mldn.cn");     //设置要发送的内容
        Channel.setMessage(msg);    //设置要发送的消息
        Channel.send();    //发送消息
    }
}
