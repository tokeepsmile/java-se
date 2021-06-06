package com.wangwei.javase.collection.generic;

/**
 * @auther wangwei
 * @date 2019-05-19 18:59
 */
public class ArrayAlg {
    public static <T extends Comparable> T min(T[] a){
        if (a == null || a.length == 0)
            return null;
        T min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0)
                min = a[i];
        }

        return min;

    }
}
