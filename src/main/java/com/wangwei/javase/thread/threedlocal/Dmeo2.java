package com.wangwei.javase.thread.threedlocal;

/**
 * @Author wangwei
 * @Date 2021/4/20 6:05 下午
 * @Version 1.0
 */
public class Dmeo2 {
    private static int value;

    private static synchronized void increment() {
        value++;
    }

    private static synchronized void decrement() {
        value--;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(Dmeo2::increment);
        Thread t2 = new Thread(Dmeo2::increment);
        Thread t3 = new Thread(Dmeo2::decrement);
        Thread t4 = new Thread(Dmeo2::decrement);

        t1.start();
        //t3.start();
        t2.start();
        t4.start();

        t1.join();
        t2.join();
        //t3.join();
        t4.join();

        System.out.println(Dmeo2.value);
    }
}
