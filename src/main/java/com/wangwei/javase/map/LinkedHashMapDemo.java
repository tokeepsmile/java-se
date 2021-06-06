package com.wangwei.javase.map;

import java.util.LinkedHashMap;

/**
 * @Author wangwei
 * @Date 2021/3/28 下午12:07
 * @Version 1.0
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
        linkedHashMap.put(3, 11);
        linkedHashMap.put(1, 12);
        linkedHashMap.put(5, 23);
        linkedHashMap.put(2, 22);
        for (Integer integer : linkedHashMap.keySet()) {
            System.out.println(integer);
        }
        System.out.println("=======================================");
        linkedHashMap.put(3, 26);
        linkedHashMap.get(5);

        for (Integer integer : linkedHashMap.keySet()) {
            System.out.println(integer);
        }
    }
}
