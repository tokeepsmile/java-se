package com.wangwei.javase.demo;

import com.wangwei.javase.demo.Person;

/**
 * @auther wangwei
 * @date 2019-05-18 14:54
 */
public class StaticDemo {
    public static void main(String[] args) {
        System.out.println(Person.getAge());

        Person person1 = new Person();
        person1.setAge(18);
        System.out.println(Person.getAge());

        Person person2 = new Person();
        person2.setAge(28);
        System.out.println(Person.getAge());





    }
}
