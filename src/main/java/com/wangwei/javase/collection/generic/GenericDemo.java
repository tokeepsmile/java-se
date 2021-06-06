package com.wangwei.javase.collection.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("wangewi");
        list.addAll(new ArrayList<>());

        print("wangwei");
        print(2);
//
//        Tool tool = new Tool(new Worker());
//
//        Worker obj = (Worker) tool.getObj();
//
//        Tool tool1 = new Tool(new Student());
//        Student obj1 = (Student) tool1.getObj();

        Util<Student> util = new Util<>();
        Student t = util.getT();


    }

    public static <T> void print(T t) {
        System.out.println("T: " + t);
    }


    class Student {

    }

    class Worker {

    }

    static class Tool {
        private Object obj;

        public Tool(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }
    }

    static class Util<T> {
        private T t;


        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }
}
