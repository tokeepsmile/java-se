package com.wangwei.javase.proxy.staticProxy.jvhe;

import com.wangwei.javase.proxy.staticProxy.Car;
import com.wangwei.javase.proxy.staticProxy.MoveAble;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午2:46
 */
@Slf4j
public class JHCarProxy implements MoveAble {

    private Car car;

    public JHCarProxy(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        log.info("汽车开始行驶");
        car.move();
        long endTime = System.currentTimeMillis();
        log.info("汽车行驶结束，耗时" + (endTime - startTime) + "毫秒");
    }
}
