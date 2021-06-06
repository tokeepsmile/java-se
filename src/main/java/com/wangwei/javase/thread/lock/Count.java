package com.wangwei.javase.thread.lock;

/**
 * @Author wangwei
 * @Date 2021/1/14 下午12:27
 * @Version 1.0
 */
public class Count {
    private long count;

    public long getCount() {
        return count;
    }

    public synchronized void addCount() {
        this.count += 1;
    }
}
