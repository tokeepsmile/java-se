package com.wangwei.javase.thread.test;

/**
 * @Author wangwei
 * @Date 2021/3/24 下午2:26
 * @Version 1.0
 */
public class ConcurrencyTest {
    private static final long COUNT = 10000L;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms, b=" + b);
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < COUNT; i++) {
                a += 5;
            }
        });
        thread.start();

        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }

        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency: " + time + "ms, b=" + b);
    }
}
