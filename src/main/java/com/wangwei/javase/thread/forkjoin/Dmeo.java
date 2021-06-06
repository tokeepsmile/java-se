package com.wangwei.javase.thread.forkjoin;

/**
 * @Author wangwei
 * @Date 2021/3/30 6:21 下午
 * @Version 1.0
 */
public class Dmeo {
    public static void main(String[] args) {
        System.out.println(sum(1, 100));
        System.out.println(5/2);
    }

    public static int sum(int start, int end){
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
