package com.wangwei.javase.thread.demo.reference;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangwei
 * @Date 2021/4/12 11:33 下午
 * @Version 1.0
 */
public class InitValueInThreadLocal {
    private static final StringBuilder INIT_VALUE = new StringBuilder("init");

    private static final ThreadLocal<StringBuilder> builder = new ThreadLocal(){
        @Override
        protected StringBuilder initialValue() {
            return INIT_VALUE;
        }
    };

    private static class AppendStingThread extends Thread {
        @Override
        public void run() {
            StringBuilder inThread = builder.get();
            for (int i = 0; i < 10; i++) {
                inThread.append("-" + i);
            }
            System.out.println(inThread.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new AppendStingThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }
}
