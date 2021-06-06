package com.wangwei.javase.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author wangwei
 * @Date 2021/2/2 下午3:03
 * @Version 1.0
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        // 创建分治任务线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        // 创建分治任务
        Fibonacci task = new Fibonacci(3);

        // 执行任务
        Integer result = forkJoinPool.invoke(task);

        System.out.println(result);
    }
}
