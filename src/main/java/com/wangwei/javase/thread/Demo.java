package com.wangwei.javase.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author wangwei
 * @Date 2021/4/20 5:53 下午
 * @Version 1.0
 */
public class Demo {
    private static AtomicLong al = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> al.incrementAndGet());
        Thread t2 = new Thread(() -> al.incrementAndGet());

        Thread t3 = new Thread(() -> al.decrementAndGet());
        Thread t4 = new Thread(() -> al.decrementAndGet());
        Thread t5 = new Thread(() -> al.incrementAndGet());

        t1.start();
        //t3.start();
        t2.start();
        t5.start();
        t4.start();

        t1.join();
        t2.join();
        //t3.join();
        t4.join();
        t5.join();

        System.out.println(al.get());
    }
}
