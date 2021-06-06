package com.wangwei.javase.collection;

import com.wangwei.javase.collection.entity.Person;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        set.add(2);
        set.forEach(i -> System.out.println(i));

        Set<Person> set2 = new HashSet<>();
        set2.add(new Person("张三", 22));
        set2.add(new Person("李四", 18));
        set2.add(new Person("王五", 21));
        set2.add(new Person("张三", 22));


        set2.forEach(p -> System.out.println(p));
    }
}
