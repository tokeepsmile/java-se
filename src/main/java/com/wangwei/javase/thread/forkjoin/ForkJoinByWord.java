package com.wangwei.javase.thread.forkjoin;

import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author wangwei
 * @Date 2021/2/3 上午10:15
 * @Version 1.0
 */
public class ForkJoinByWord {
    public static void main(String[] args) {
        String[] fc = {"hello world", "hello me", "hello fork", "hello join", "fork join in world"};

        ForkJoinPool forkJoinPool = new ForkJoinPool(3);

        MR mr = new MR(fc, 0, fc.length);

        Map<String, Long> result = forkJoinPool.invoke(mr);

        result.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }
}
