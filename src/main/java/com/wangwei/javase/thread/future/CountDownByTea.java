package com.wangwei.javase.thread.future;


import com.wangwei.javase.thread.test.SleepUtils;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wangwei
 * @Date 2021/1/29 下午4:19
 * @Version 1.0
 */
public class CountDownByTea {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(new T1Task(countDownLatch));
        t1.start();
        Thread t2 = new Thread(new T2Task(countDownLatch));
        t2.start();
    }

    // 负责 洗水壶 烧开水 泡茶
    static class T1Task implements Runnable{
        private CountDownLatch countDownLatch;

        public T1Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("T1 => 洗水壶...");
            SleepUtils.second(1);

            System.out.println("T1 => 烧开水...");
            SleepUtils.second(5);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1: 拿到茶叶：");

            System.out.println("T1: 上茶...龙井");
        }
    }

    static class T2Task implements Runnable{
        CountDownLatch countDownLatch;

        public T2Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("T2 => 洗茶壶...");
            SleepUtils.second(1);

            System.out.println("T2 => 洗茶杯...");
            SleepUtils.second(2);

            System.out.println("T2 => 拿茶叶...");
            SleepUtils.second(1);
            countDownLatch.countDown();
        }
    }
}
