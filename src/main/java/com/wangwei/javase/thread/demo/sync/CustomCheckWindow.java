package com.wangwei.javase.thread.demo.sync;

import java.util.concurrent.Semaphore;

/**
 * @Author wangwei
 * @Date 2020/11/24 下午6:34
 * @Version 1.0
 */
public class CustomCheckWindow {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            new SecurityCheckThread(semaphore, i).start();
        }
    }

    private static class SecurityCheckThread extends Thread{
        private int seq;
        private Semaphore semaphore;
        public SecurityCheckThread(Semaphore semaphore, int seq){
            this.semaphore = semaphore;
            this.seq = seq;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + seq + "乘客,正在接受检查.");
                if (seq % 2 == 0){
                    Thread.sleep(1000);
                    System.out.println("No." + seq + "乘客, 身份可疑, 不可以出国!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
                System.out.println("No." + seq + "乘客, 已完成服务.");
            }
        }
    }
}
