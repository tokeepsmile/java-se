package com.wangwei.javase.proxy.staticProxy;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 被代理类
 *
 * @Auther wangwei
 * @Date 2018/5/5 下午2:40
 */
@Slf4j
public class Car implements MoveAble {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            log.info("汽车行驶中。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
