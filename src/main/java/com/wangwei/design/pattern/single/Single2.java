package com.wangwei.design.pattern.single;

/**
 * @Author wangwei
 * @Date 2021/4/19 10:14 下午
 * @Version 1.0
 */
public class Single2 {
    private static final Single2 INSTANCE = new Single2();

    private Single2(){};

    public static Single2 getInstance(){
        return INSTANCE;
    }
}
