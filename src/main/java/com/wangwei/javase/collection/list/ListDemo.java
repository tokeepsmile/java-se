package com.wangwei.javase.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(5);
        System.out.println("arrayList => " + arrayList);

        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(6);
        linkedList.add(1);
        linkedList.add(5);

        System.out.println("linkedList => " + linkedList);
    }
}
