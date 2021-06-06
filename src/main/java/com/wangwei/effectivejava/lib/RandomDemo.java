package com.wangwei.effectivejava.lib;

import java.util.Random;

/**
 * @auther wangwei
 * @date 2019-05-28 23:35
 */
public class RandomDemo {
    static Random random = new Random();

    public static void main(String[] args) {
        long waitTimExp = getWaitTimExp(2000);
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (randow(n) < n/2)
                low++;
        }

        System.out.println(low);
    }

    static int randow(int n){
        return Math.abs(random.nextInt()) % n;
    }

    public static long getWaitTimExp(int retry){
        return (long) Math.pow(2, retry);
    }
}
