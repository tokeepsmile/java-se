package com.wangwei.javase.proxy.jdkProxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午3:12
 */
@Slf4j
public class CarTimeJDKProxy implements InvocationHandler {

    private Object target;

    public CarTimeJDKProxy(Object target) {
        this.target = target;
    }

    /**
     * proxy:被代理类
     * method：被代理类的方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("汽车开始行驶");
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        log.info("汽车行驶结束，耗时" + (endTime - startTime) + "毫秒");
        return null;
    }
}
