package com.wangwei.javase.proxy.staticProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午2:46
 */
@Slf4j
public class CarTimeProxy implements MoveAble {

    private MoveAble moveAble;

    public CarTimeProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        log.info("汽车开始行驶");
        moveAble.move();
        long endTime = System.currentTimeMillis();
        log.info("汽车行驶结束，耗时" + (endTime - startTime) + "毫秒");
    }
}
