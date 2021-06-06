package com.wangwei.javase.thread.future;


import com.wangwei.javase.thread.test.SleepUtils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @Author wangwei
 * @Date 2021/2/1 上午11:02
 * @Version 1.0
 */
public class CompletableFutureORDemo {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            int i = new Random().nextInt();
            SleepUtils.second(i);
            return String.valueOf(i);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            int i = new Random().nextInt();
            SleepUtils.second(i);
            return String.valueOf(i);
        });

        CompletableFuture<String> f3 = f1.applyToEither(f2, s -> s);

        System.out.println(f3.join());
    }
}
