package com.wangwei.javase.thread.test;


/**
 * @Author wangwei
 * @Date 2021/3/25 下午6:44
 * @Version 1.0
 */
public class ThreadShutdown {
    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        SleepUtils.second(1);
        one.cacel();
    }

    static class Runner implements Runnable{
        private int i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count = " + i);
        }

        private void cacel(){
            on = false;
        }
    }


}
