package com.wangwei.design.pattern.single;

/**
 * @Author wangwei
 * @Date 2021/4/19 10:17 下午
 * @Version 1.0
 */
public class Single4 {
    private Single4(){};
    private static class SingleHolder{
        private static final Single4 INSTANCE = new Single4();
    }
    public static Single4 getInstance(){
        return SingleHolder.INSTANCE;
    }
}
