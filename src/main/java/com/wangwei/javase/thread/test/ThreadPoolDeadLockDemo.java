package com.wangwei.javase.thread.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wangwei
 * @Date 2021/2/8 下午2:27
 * @Version 1.0
 */
public class ThreadPoolDeadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        CountDownLatch l1 = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            es.execute(() -> {
                System.out.println("L1");
                CountDownLatch l2 = new CountDownLatch(2);
                for (int j = 0; j < 2; j++) {
                    es.execute(() -> {
                        System.out.println("L2");
                        l2.countDown();
                    });
                }
                try {
                    l2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.countDown();
            });
        }

        l1.await();
        System.out.println("end");
    }
}
