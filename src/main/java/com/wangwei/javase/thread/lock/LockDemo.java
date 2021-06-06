package com.wangwei.javase.thread.lock;

/**
 * @Author wangwei
 * @Date 2021/1/14 下午12:29
 * @Version 1.0
 */
public class LockDemo {
    public static void main(String[] args) {
        Count count = new Count();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                count.addCount();
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("count= " + count.getCount());
            }).start();
        }
    }
}
