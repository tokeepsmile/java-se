package com.wangwei.serializable;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @Auther wangwei
 * @Date 2018/4/27 上午11:16
 */
@Slf4j
public class SerializableTest {
    public static void main(String[] args) throws Exception {

        /**
         * 序列化对象
         */
//        FileOutputStream fos = new FileOutputStream("/Users/wangwei/opt/temp.out");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        TestObject testObject = new TestObject();
//        oos.writeObject(testObject);
//        oos.flush();
//        oos.close();

        /**
         * 反序列化
         */
        FileInputStream fis = new FileInputStream("/Users/wangwei/opt/temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestObject testObject1 = (TestObject) ois.readObject();
        log.info("testValue={}", testObject1.testValue);
        log.info("parentValue={}", testObject1.parentValue);
        log.info("InnerValue={}", testObject1.innerObject.innerValue);


    }
}
