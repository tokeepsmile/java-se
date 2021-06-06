package com.wangwei.design.pattern.single;

/**
 * @Author wangwei
 * @Date 2021/4/19 10:15 下午
 * @Version 1.0
 */
public class Single3 {
    private static Single3 instance;
    private Single3(){};
    public static Single3 getInstance(){
        if (instance == null){
            synchronized (Single3.class){
                if (instance == null){
                    instance = new Single3();
                }
            }
        }
        return instance;
    }
}
