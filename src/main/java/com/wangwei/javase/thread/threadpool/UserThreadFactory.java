package com.wangwei.javase.thread.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wangwei
 * @Date 2020/11/24 下午7:33
 * @Version 1.0
 */
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    // 定义线程组名称，在使用jstack来排查线程问题时，非常有帮助
    public UserThreadFactory(String whatFeatureOfGroup) {
        this.namePrefix = "UserThreadFactory" + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }

}
