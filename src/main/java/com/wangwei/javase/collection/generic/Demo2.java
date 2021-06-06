package com.wangwei.javase.collection.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <?> ？可理解为通配符或占位符
 * 泛形的限定：
 * ? extends E: 可以接受E类型或者E的子类型   上限
 * ？ super E: 可以接受E类型或者E的父类型     下限
 */
public class Demo2 {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList();
        list.add(new Person("abc1"));
        list.add(new Person("abc3"));
        list.add(new Person("abc2"));


        ArrayList<Student> list1 = new ArrayList();
        list1.add(new Student("abc1"));
        list1.add(new Student("abc3"));
        list1.add(new Student("abc2"));

        printCollection(list);

        printCollection(list1);
    }


    /**
     * 只打印person以及person的子类
     *
     * @param list
     */
    public static void printCollection(ArrayList<? extends Person> list) {
        Iterator<? extends Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }

    static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Student extends Person {

        private String name;

        public Student(String name) {
            super(name);
        }


    }
}
