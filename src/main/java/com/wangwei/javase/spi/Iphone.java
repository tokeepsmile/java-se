package com.wangwei.javase.spi;

/**
 * @Author wangwei
 * @Date 2021/4/16 9:34 下午
 * @Version 1.0
 */
public class Iphone  implements Apple{

    @Override
    public void printProductName() {
        System.out.println("I'm an apple iphone");
    }
}
