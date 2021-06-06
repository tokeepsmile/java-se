package com.wangwei.javase.thread.threadpool;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author wangwei
 * @Date 2020/11/24 下午7:41
 * @Version 1.0
 */
public class Task implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);
    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
