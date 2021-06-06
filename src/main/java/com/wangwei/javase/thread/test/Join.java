package com.wangwei.javase.thread.test;

/**
 * @Author wangwei
 * @Date 2021/4/22 9:42 下午
 * @Version 1.0
 */
public class Join {
    public static void main(String[] args) {
        Thread prev = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JoinT(prev), String.valueOf(i));
            thread.start();
            prev = thread;
        }
        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName() + " terminte.");
    }

    static class JoinT implements Runnable {
        private Thread prev;

        public JoinT(Thread prev) {
            this.prev = prev;
        }

        @Override
        public void run() {
            try {
                prev.join();
            }catch (InterruptedException e){

            }
            System.out.println(Thread.currentThread().getName() + " terminte.");
        }
    }
}
