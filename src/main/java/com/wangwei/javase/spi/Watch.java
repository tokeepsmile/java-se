package com.wangwei.javase.spi;

/**
 * @Author wangwei
 * @Date 2021/4/16 9:35 下午
 * @Version 1.0
 */
public class Watch implements Apple{
    @Override
    public void printProductName() {
        System.out.println("I'm a apple watch");
    }
}
