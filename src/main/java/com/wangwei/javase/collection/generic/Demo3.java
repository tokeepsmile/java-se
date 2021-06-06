package com.wangwei.javase.collection.generic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Demo3 {
    public static void main(String[] args) {
//        TreeSet<Student> set = new TreeSet<>(new comp());
//        set.add(new Student("abc--1"));
//        set.add(new Student("abc--3"));
//        set.add(new Student("abc--8"));
//        set.add(new Student("abc--2"));
//        Iterator<Worker> iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next().getName());
//        }

        TreeSet<Worker> set = new TreeSet<>(new comp());
        set.add(new Worker("abc w--1"));
        set.add(new Worker("abc w--3"));
        set.add(new Worker("abc w--8"));
        set.add(new Worker("abc w--2"));

        Iterator<Worker> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }


    }

    static class comp implements Comparator<Person> {


        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
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

        public Student(String name) {
            super(name);
        }
    }

    static class Worker extends Person {

        public Worker(String name) {
            super(name);
        }
    }
}
