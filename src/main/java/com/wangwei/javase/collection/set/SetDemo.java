package com.wangwei.javase.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @Author wangwei
 * @Date 2021/3/27 上午11:04
 * @Version 1.0
 */
public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("xiaoming");
        hashSet.add("wangwu");
        hashSet.add("zhaoliu");
        hashSet.add("xiaoming");
        hashSet.add("lisi");

        System.out.println("HashSet => " + hashSet);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("xiaoming");
        treeSet.add("wangwu");
        treeSet.add("zhaoliu");
        treeSet.add("xiaoming");
        treeSet.add("lisi");
        System.out.println("TreeSet => " + treeSet);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("xiaoming");
        linkedHashSet.add("wangwu");
        linkedHashSet.add("zhaoliu");
        linkedHashSet.add("xiaoming");
        linkedHashSet.add("lisi");

        System.out.println("LinkedHashSet => " + linkedHashSet);
    }
}
