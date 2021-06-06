package com.wangwei.javase.list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author wangwei
 * @Date 2020/4/3 11:09 下午
 * @Version 1.0
 */
public class ListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(3);
        list.add("one");
        list.add("two");
        list.add("three");
        // 泛型丢失
        Object[] objects = list.toArray();

        String[] arr2 = new String[2];
        list.toArray(arr2);
        System.out.println(Arrays.asList(arr2));

        String[] arr3 = new String[list.size()];
        list.toArray(arr3);
        System.out.println(Arrays.asList(arr3));
    }
}
