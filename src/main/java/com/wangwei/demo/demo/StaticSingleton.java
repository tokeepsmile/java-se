package com.wangwei.demo.demo;

public class StaticSingleton {
    private StaticSingleton() {
    }

    private static class SingletonHolder {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
