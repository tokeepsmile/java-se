package com.wangwei.javase.thread.concurrency.inaction.test;

/**
 * @Author wangwei
 * @Date 2021/3/24 下午3:02
 * @Version 1.0
 */
public class DeadLockDemo {
    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLoack();
    }

    private void deadLoack() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A){
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
