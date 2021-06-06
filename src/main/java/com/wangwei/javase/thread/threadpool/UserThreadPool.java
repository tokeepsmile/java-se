package com.wangwei.javase.thread.threadpool;

import com.wangwei.javase.thread.threadpool.Task;
import com.wangwei.javase.thread.threadpool.UserRejectHandler;
import com.wangwei.javase.thread.threadpool.UserThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangwei
 * @Date 2020/11/24 下午7:33
 * @Version 1.0
 */
public class UserThreadPool {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(2);
        UserThreadFactory userThreadFactory1 = new UserThreadFactory("王家坝第一机房");
        UserThreadFactory userThreadFactory2 = new UserThreadFactory("王家坝第二机房");

        UserRejectHandler userRejectHandler = new UserRejectHandler();
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, userThreadFactory1, userRejectHandler);
        //ThreadPoolExecutor executor2 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, userThreadFactory2, userRejectHandler);

        Task task = new Task();
        for (int i = 0; i < 5; i++) {
            executor1.execute(task);
            //executor2.execute(task);
        }
    }
}
