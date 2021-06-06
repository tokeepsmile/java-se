package com.wangwei.javase.thread.lock;


import com.wangwei.javase.thread.test.SleepUtils;

/**
 * @Author wangwei
 * @Date 2021/3/26 下午2:10
 * @Version 1.0
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        final TwinsLock lock = new TwinsLock();

        class Worker extends Thread{
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }
        //for (int i = 0; i < 10; i++) {
        //    Thread thread = new Thread(() -> {
        //        while (true) {
        //            lock.lock();
        //            try {
        //                SleepUtils.second(1);
        //                System.out.println(Thread.currentThread().getName());
        //                SleepUtils.second(1);
        //            } catch (Exception e) {
        //                e.printStackTrace();
        //            } finally {
        //                lock.unlock();
        //            }
        //        }
        //    });
        //    thread.setDaemon(true);
        //    thread.start();
        //}

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }


}
