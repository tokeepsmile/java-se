package com.wangwei.design.pattern.behavior.responsibility;

/**
 * @Author wangwei
 * @Date 2021/4/7 12:49 下午
 * @Version 1.0
 */
public class HandlerC extends Handler{
    @Override
    protected void doHandle() {
        System.out.println("HandlerC doHandle()");
    }
}
