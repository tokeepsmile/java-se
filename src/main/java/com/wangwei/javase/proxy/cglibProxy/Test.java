package com.wangwei.javase.proxy.cglibProxy;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午3:46
 */
public class Test {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Train t = (Train) cglibProxy.getProxy(Train.class);
        t.movie();
    }
}
