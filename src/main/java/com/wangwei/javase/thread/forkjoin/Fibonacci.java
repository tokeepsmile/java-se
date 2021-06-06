package com.wangwei.javase.thread.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Author wangwei
 * @Date 2021/2/2 下午3:04
 * @Version 1.0
 */
public class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n<=1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);

        // 创建子任务
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }
}
