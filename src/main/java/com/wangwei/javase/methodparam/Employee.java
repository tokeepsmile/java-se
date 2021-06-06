package com.wangwei.javase.methodparam;

import java.time.LocalDate;

/**
 * @auther wangwei
 * @date 2019-05-19 11:25
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void  raisSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }


}
