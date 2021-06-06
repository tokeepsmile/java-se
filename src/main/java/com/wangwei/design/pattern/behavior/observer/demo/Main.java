package com.wangwei.design.pattern.behavior.observer.demo;

/**
 * @Author wangwei
 * @Date 2020/4/26 8:36 上午
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        Message message = new Message();
        message.setMsg("hello");
        subject.notifyObservers(message);
    }
}
