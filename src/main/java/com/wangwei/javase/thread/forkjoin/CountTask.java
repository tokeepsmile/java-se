package com.wangwei.javase.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author wangwei
 * @Date 2021/3/30 6:26 下午
 * @Version 1.0
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println(start + ", " + end);
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute){
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完毕并获得结果
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 100);
        Future<Integer> result = forkJoinPool.submit(countTask);
        try {
            System.out.println(result.get());
        }catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
