package com.wangwei.javase.thread.future;


import com.wangwei.javase.thread.test.SleepUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author wangwei
 * @Date 2021/1/29 下午3:59
 * @Version 1.0
 */
public class FutureByTea {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft2 = new FutureTask<String>(new T2Task());
        FutureTask<String> ft1 = new FutureTask<String>(new T1Task(ft2));

        Thread t1 = new Thread(ft1);
        t1.start();

        Thread t2 = new Thread(ft2);
        t2.start();

        System.out.println(ft1.get());
    }

    // 负责 洗水壶 烧开水 泡茶
    static class T1Task implements Callable<String>{
        FutureTask<String> ft2;

        public T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            System.out.println("T1 => 洗水壶...");
            SleepUtils.second(1);

            System.out.println("T1 => 烧开水...");
            SleepUtils.second(5);

            String tea = ft2.get();
            System.out.println("T1: 拿到茶叶：" + tea);

            System.out.println("T1: 泡茶...");
            return "上茶: " + tea;
        }
    }

    // 负责 洗茶壶 洗茶杯 拿茶叶
    static class T2Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("T2 => 洗茶壶...");
            SleepUtils.second(1);

            System.out.println("T2 => 洗茶杯...");
            SleepUtils.second(2);

            System.out.println("T2 => 拿茶叶...");
            SleepUtils.second(1);

            return "龙井";
        }
    }
}
