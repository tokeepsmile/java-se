package com.wangwei.javase.thread.test;

/**
 * @Author wangwei
 * @Date 2021/1/7 上午10:40
 * @Version 1.0
 */
public class VisibilityDemo {

    private static volatile long count = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(calc());
    }
    public void add10k(){
        int idx = 0;
        while (idx++ < 10000){
            count+=1;
        }
    }

    public static long calc() throws InterruptedException {
        VisibilityDemo visibilityDemo = new VisibilityDemo();

        Thread t1 = new Thread(() -> {
            visibilityDemo.add10k();
        });

        Thread t2 = new Thread(() -> {
            visibilityDemo.add10k();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return count;
    }


}
