package com.wangwei.design.pattern.observer.demo;

/**
 * @Author wangwei
 * @Date 2020/4/26 8:36 上午
 * @Version 1.0
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified. => " + message.toString());
    }
}
