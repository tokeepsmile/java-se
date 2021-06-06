package com.wangwei.javase.proxy.staticProxy.extendsProxy;

import com.wangwei.javase.proxy.staticProxy.Car;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午2:41
 */
@Slf4j
public class ExtendCarProxy extends Car {

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        log.info("汽车开始行驶");
        super.move();
        long endTime = System.currentTimeMillis();
        log.info("汽车行驶结束，耗时" + (endTime - startTime) + "毫秒");
    }
}
