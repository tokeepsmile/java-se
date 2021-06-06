package com.wangwei.javase.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author wangwei
 * @Date 2021/1/28 上午11:14
 * @Version 1.0
 */
public class MyThread {
    private BlockingQueue<Runnable> workQueue;
    private List<WorkThread> workThreads = new ArrayList<>();

    public MyThread(int poolSize, BlockingQueue blockingQueue) {
        this.workQueue = blockingQueue;
        for (int i = 0; i < poolSize; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            workThreads.add(workThread);
        }
    }

    void execute(Runnable runnable) throws InterruptedException {
        workQueue.put(runnable);
    }

    class WorkThread extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Runnable take = workQueue.take();
                    take.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(2);
        MyThread myThread = new MyThread(10, blockingQueue);
        myThread.execute(() -> {
            System.out.println("hello");
        });
    }

}
