package com.wangwei.design.pattern.behavior.responsibility;

/**
 * @Author wangwei
 * @Date 2020/4/27 9:08 下午
 * @Version 1.0
 */
public class HandlerB extends Handler {

    @Override
    protected void doHandle() {
        System.out.println("HandlerB doHandle()");
    }
}
