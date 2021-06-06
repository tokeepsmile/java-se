package com.wangwei.javase.collection.generic;



import java.util.ArrayList;
import java.util.Iterator;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("lgs");
        list.add("wsl");

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        printList2(list);
        printList2(list1);

    }


    public static <T> void printList(ArrayList<T> list) {

        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static void printList2(ArrayList<?> list) {

        Iterator<?> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
