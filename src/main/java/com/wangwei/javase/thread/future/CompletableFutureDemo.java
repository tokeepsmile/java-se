package com.wangwei.javase.thread.future;

import java.util.concurrent.CompletableFuture;

/**
 * @Author wangwei
 * @Date 2021/1/30 上午11:25
 * @Version 1.0
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.
                supplyAsync(() -> "Hello World").
                thenApply(s -> s + " QQ")
                .thenApply(String::toUpperCase);

        System.out.println(future.join());
    }
}
