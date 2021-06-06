package com.wangwei.javase.thread.concurrency.inaction.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wangwei
 * @Date 2021/3/25 下午4:09
 * @Version 1.0
 */
public class Counter {
    private AtomicInteger ai = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        Counter counter = new Counter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    counter.count();
                    counter.safeConut();
                }
            });
            list.add(thread);
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        System.out.println(counter.i);
        System.out.println(counter.ai.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeConut() {
        for (;;){
            int i = ai.get();
            boolean b = ai.compareAndSet(i, ++i);
            if (b){
                break;
            }
        }
    }

    private void count() {
        i++;
    }


}
