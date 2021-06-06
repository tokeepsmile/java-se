package com.wangwei.javase.collection.generic;

import lombok.Getter;

/**
 * @auther wangwei
 * @date 2019-05-19 18:56
 */
@Getter
public class Pair<T> {
    private T first;
    private T sencod;

    public Pair() {
        first = null;
        sencod = null;
    }

    public Pair(T first, T sencod) {
        this.first = first;
        this.sencod = sencod;
    }
}
