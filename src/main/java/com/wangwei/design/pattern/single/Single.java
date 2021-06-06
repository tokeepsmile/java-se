package com.wangwei.design.pattern.single;

/**
 * @Author wangwei
 * @Date 2021/4/19 10:12 下午
 * @Version 1.0
 */
public class Single {
    private static Single instance;

    private Single() {}

    public static synchronized Single getInstance(){
        if (instance == null){
            instance = new Single();
        }
        return instance;
    }
}
