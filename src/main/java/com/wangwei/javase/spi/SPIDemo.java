package com.wangwei.javase.spi;

import java.util.ServiceLoader;

/**
 * @Author wangwei
 * @Date 2021/4/16 9:38 下午
 * @Version 1.0
 */
public class SPIDemo {
    public static void main(String[] args) {
        ServiceLoader<Apple> spi = ServiceLoader.load(Apple.class);
        for (Apple apple : spi) {
            apple.printProductName();
        }
    }
}
