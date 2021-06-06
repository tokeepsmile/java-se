package com.wangwei.javase.thread.demo.reference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wangwei
 * @Date 2021/4/13 12:08 上午
 * @Version 1.0
 */
public class DdirtyDataInThreadLocal {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    private static class MyThread extends Thread {
        private static boolean flag = true;

        @Override
        public void run () {
            if (flag){
                THREAD_LOCAL.set(this.getName() + ", session info.");
                flag = false;
            }
            System.out.println(this.getName() + " 线程是 " + THREAD_LOCAL.get());
            THREAD_LOCAL.remove();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            MyThread myThread = new MyThread();
            executorService.execute(myThread);
        }
    }
}
