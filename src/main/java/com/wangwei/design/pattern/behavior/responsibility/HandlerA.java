package com.wangwei.design.pattern.behavior.responsibility;

/**
 * @Author wangwei
 * @Date 2020/4/27 9:07 下午
 * @Version 1.0
 */
public class HandlerA extends Handler {

    @Override
    protected void doHandle() {
        System.out.println("HandlerA doHandle()");
    }
}
