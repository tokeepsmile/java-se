package com.wangwei.design.pattern.responsibility;

/**
 * @Author wangwei
 * @Date 2020/4/27 9:08 下午
 * @Version 1.0
 */
public class HandlerB extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        //...
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
