package com.wangwei.design.pattern.responsibility;

/**
 * @Author wangwei
 * @Date 2020/4/27 9:09 下午
 * @Version 1.0
 */
// 使用举例
public class Application {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
