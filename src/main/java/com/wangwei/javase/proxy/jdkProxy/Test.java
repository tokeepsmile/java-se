package com.wangwei.javase.proxy.jdkProxy;

import com.wangwei.javase.proxy.staticProxy.Car;
import com.wangwei.javase.proxy.staticProxy.MoveAble;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理测试类
 *
 * @Auther wangwei
 * @Date 2018/5/5 下午3:16
 */
public class Test {

    public static void main(String[] args) {

        Car car = new Car();
        InvocationHandler h = new CarTimeJDKProxy(car);
        Class<?> carClass = car.getClass();

        /**
         * loader 类加载器
         * interfaces 实现接口
         * InvocationHandler h
         */
        MoveAble m = (MoveAble) Proxy.newProxyInstance(carClass.getClassLoader(), carClass.getInterfaces(), h);

        m.move();
    }
}
