package com.wangwei.design.pattern.structure.compose;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/28 10:22 上午
 * @Version 1.0
 */
public class Department extends HumanResource {
    private List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource hr : subNodes) {
            totalSalary += hr.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }
}
