package com.wangwei.javase.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author wangwei
 * @Date 2021/1/29 下午3:24
 * @Version 1.0
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);
        ExecutorService threadPool = Executors.newCachedThreadPool();

        threadPool.submit(futureTask);

        Integer integer = futureTask.get();

        System.out.println(integer);
    }
}
