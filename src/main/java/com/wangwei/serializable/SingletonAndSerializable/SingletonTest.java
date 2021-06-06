package com.wangwei.serializable.SingletonAndSerializable;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Auther wangwei
 * @Date 2018/4/27 下午12:07
 */
@Slf4j
public class SingletonTest {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.out"));
        oos.writeObject(Singleton.getSingleton());
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.out"));
        Singleton singletonNew = (Singleton) ois.readObject();
        log.info("判断单例模式是否被序列化破坏：{}", singletonNew == Singleton.getSingleton());
    }
}
