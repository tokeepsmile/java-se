package com.wangwei.javase.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author wangwei
 * @Date 2021/1/29 下午3:30
 * @Version 1.0
 */
public class ThreadFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);
        Thread thread = new Thread(futureTask);
        thread.start();

        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
