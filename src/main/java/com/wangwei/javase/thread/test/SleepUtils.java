package com.wangwei.javase.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangwei
 * @Date 2021/1/11 上午10:18
 * @Version 1.0
 */
public class SleepUtils {
    public static void second(long senconds){
        try {
            TimeUnit.SECONDS.sleep(senconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
