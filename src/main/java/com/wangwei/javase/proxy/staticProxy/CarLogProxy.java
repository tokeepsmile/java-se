package com.wangwei.javase.proxy.staticProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午2:52
 */
@Slf4j
public class CarLogProxy implements MoveAble {

    private MoveAble moveAble;

    public CarLogProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        log.info("日志开始");
        moveAble.move();
        log.info("日志结束");
    }
}
