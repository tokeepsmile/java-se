package com.wangwei.javase.thread.lock;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author wangwei
 * @Date 2021/3/30 1:05 下午
 * @Version 1.0
 */
public class Cache {
    public static final HashMap<String, Object> HASH_MAP = new HashMap<>();
    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static Lock readLock = rwl.readLock();
    private static Lock writeLock = rwl.writeLock();

    public static Object put(String key, Object value){
        writeLock.lock();
        try {
            return HASH_MAP.put(key, value);
        }finally {
            writeLock.unlock();
        }
    }

    public static Object get(String key){
        readLock.lock();
        try {
            return HASH_MAP.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static void clean(){
        writeLock.lock();
        try {
            HASH_MAP.clear();
        }finally {
            writeLock.unlock();
        }
    }
}
