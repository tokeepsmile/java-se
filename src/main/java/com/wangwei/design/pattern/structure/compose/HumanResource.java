package com.wangwei.design.pattern.structure.compose;

/**
 * @Author wangwei
 * @Date 2020/4/28 10:20 上午
 * @Version 1.0
 * 假设我们在开发一个 OA 系统（办公自动化系统）。
 * 公司的组织结构包含部门和员工两种数据类型。其中，部门又可以包含子部门和员工。在数据库中的表结构如下所示：
 */

public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
