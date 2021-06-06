package com.wangwei.javase.map;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author wangwei
 * @Date 2021/3/27 下午4:10
 * @Version 1.0
 */
public class TreepMapRepeat {
    public static void main(String[] args) {
        TreeMap<Key, String> treeMap = new TreeMap<>();
        treeMap.put(new Key(), "value one");
        treeMap.put(new Key(), "value two");
        System.out.println(treeMap.size());
        HashMap<Key, String> hashMap = new HashMap<>();
        hashMap.put(new Key(), "value one");
        hashMap.put(new Key(), "value two");
        System.out.println(hashMap.size());
    }
}
