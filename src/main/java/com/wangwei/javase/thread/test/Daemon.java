package com.wangwei.javase.thread.test;

/**
 * @Author wangwei
 * @Date 2021/1/11 上午10:18
 * @Version 1.0
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                System.out.println("DaemonRunner finally run.");
            }
        }
    }
}
