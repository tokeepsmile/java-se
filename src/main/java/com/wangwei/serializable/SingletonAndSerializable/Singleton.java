package com.wangwei.serializable.SingletonAndSerializable;

import java.io.Serializable;

/**
 * @Auther wangwei
 * @Date 2018/4/27 下午12:03
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = 4920710412702123089L;

    private Singleton() {
    }

    ;
    private volatile static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

    /**
     * 防止序列化过程破坏单列模式
     *
     * @return
     */
    private Object readResolve() {
        return singleton;
    }
}
