package com.wangwei.javase.thread.test;

/**
 * @Author wangwei
 * @Date 2021/1/11 上午10:32
 * @Version 1.0
 */
public class Interrputted {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepRunner");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyRunner");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        SleepUtils.second(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());

        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            int i = 1;
            while (true){
                System.out.println("BusyRunner run " + i++);
            }
        }
    }
}
