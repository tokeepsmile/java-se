package com.wangwei.javase.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @Author wangwei
 * @Date 2021/2/2 上午11:01
 * @Version 1.0
 */
public class CompletionServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> esc = new ExecutorCompletionService<>(executorService);
        List<Future<Integer>> futureList = new ArrayList<>();
        futureList.add(esc.submit(() -> MapApi.addressCastNumber("baidu")));
        futureList.add(esc.submit(() -> MapApi.addressCastNumber("gaode")));
        futureList.add(esc.submit(() -> MapApi.addressCastNumber("tengxun")));

        // 获取最快执行的结果
        Integer r = 0;
        try {
            for (int i = 0; i < 3; i++) {
                r = esc.take().get();
                if (Objects.nonNull(r)) {
                    break;
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            for (Future<Integer> future : futureList) {
                future.cancel(true);
            }
        }

        System.out.println(r);
    }
}
