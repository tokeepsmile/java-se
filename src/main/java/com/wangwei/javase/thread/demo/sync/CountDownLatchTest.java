package com.wangwei.javase.thread.demo.sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangwei
 * @Date 2020/11/24 下午6:45
 * @Version 1.0
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        TranslateThread thread1 = new TranslateThread(countDownLatch, "1st content");
        TranslateThread thread2 = new TranslateThread(countDownLatch, "2nd content");
        TranslateThread thread3 = new TranslateThread(countDownLatch, "3rd content");
        thread1.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println(thread.getName() + " : " + e.getMessage());
        });
        thread1.start();

        thread2.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println(thread.getName() + " : " + e.getMessage());
        });
        thread2.start();

        thread3.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println(thread.getName() + " : " + e.getMessage());
        });
        thread3.start();
        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("所有线程执行完成");
    }
}
