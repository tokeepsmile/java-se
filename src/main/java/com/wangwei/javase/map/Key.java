package com.wangwei.javase.map;

/**
 * @Author wangwei
 * @Date 2021/3/27 下午4:10
 * @Version 1.0
 */
public class Key implements Comparable<Key> {
    @Override
    public int compareTo(Key o) {
        return -1;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
