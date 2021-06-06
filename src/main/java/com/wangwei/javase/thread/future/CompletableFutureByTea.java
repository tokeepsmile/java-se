package com.wangwei.javase.thread.future;


import com.wangwei.javase.thread.test.SleepUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @Author wangwei
 * @Date 2021/1/29 下午6:10
 * @Version 1.0
 */
public class CompletableFutureByTea {
    public static void main(String[] args) {

        // 负责 洗水壶 烧开水
        CompletableFuture<Void> t1  = CompletableFuture.runAsync(() -> {
            System.out.println("T1 => 洗水壶...");
            SleepUtils.second(1);

            System.out.println("T1 => 烧开水...");
            SleepUtils.second(5);
        });

        //负责 洗茶壶 洗水杯 拿茶叶
        CompletableFuture<String> t2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2 => 洗茶壶...");
            SleepUtils.second(1);

            System.out.println("T2 => 洗水杯...");
            SleepUtils.second(2);

            System.out.println("T2 => 拿茶叶...");

            return "龙井";
        });

        CompletableFuture<String> t3 = t1.thenCombine(t2, (__, tf) -> {
            System.out.println("T1 => 拿到茶叶: " + tf);
            System.out.println("T3 => 泡茶。。。");
            SleepUtils.second(3);
            return "上茶: " + tf;
        });

        System.out.println(t3.join());
    }
}
