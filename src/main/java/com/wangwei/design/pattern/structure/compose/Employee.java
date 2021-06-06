package com.wangwei.design.pattern.structure.compose;

/**
 * @Author wangwei
 * @Date 2020/4/28 10:21 上午
 * @Version 1.0
 */
public class Employee extends HumanResource {
    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}