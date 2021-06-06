package com.wangwei.javase.methodparam;

/**
 * @auther wangwei
 * @date 2019-05-19 11:53
 */
public class Test {
    public static void main(String[] args) {

        Employee e = new Employee("wangwei", 15000.0, 2019, 5, 7);

        System.out.println(e.getSalary());

        tripleSalary(e);

        System.out.println(e.getSalary());

    }

    public static void tripleSalary(Employee e){
        e.raisSalary(200);
    }


    public static void swap(Employee a, Employee b){
        Employee temp = a;
        a = b;
        b =temp;
    }
}
