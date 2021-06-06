package com.wangwei.demo.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DiceBlockingQueue {

    private static volatile boolean flag = true;

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        new Thread(new A(queue)).start();
        new Thread(new B(queue)).start();


    }

    private static class A implements Runnable {

        private BlockingQueue<Integer> queue;

        public A(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (flag) {
                int num = (int) (Math.random() * 6 + 1);
                try {
                    queue.put(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class B implements Runnable {

        private BlockingQueue<Integer> queue;

        public B(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int num;
            int count = 0;
            while (flag) {
                try {
                    num = queue.take();
                    if (3 == num) {
                        System.out.println("a线程本次掷的骰子数是: " + num);
                        count++;
                        if (3 == count) {
                            flag = false;
                            System.out.println("累计连续输出3个3,进程结束！！！");
                            queue.clear();
                        }
                    } else {
                        count = 0;
                        System.out.println("a线程本次掷的骰子数是: " + num);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
