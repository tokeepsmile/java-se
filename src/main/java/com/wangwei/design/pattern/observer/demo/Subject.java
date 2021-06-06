package com.wangwei.design.pattern.observer.demo;

/**
 * @Author wangwei
 * @Date 2020/4/26 8:33 上午
 * @Version 1.0
 */

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}