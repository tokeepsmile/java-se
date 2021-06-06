package com.wangwei.design.pattern.structure.compose;//package com.wangwei.structure.compose;
//
///**
// * @Author wangwei
// * @Date 2020/4/28 10:22 上午
// * @Version 1.0
// */
//// 构建组织架构的代码
//public class Demo {
//    private static final long ORGANIZATION_ROOT_ID = 1001;
//    private DepartmentRepo departmentRepo; // 依赖注入
//    private EmployeeRepo employeeRepo; // 依赖注入
//
//    public void buildOrganization() {
//        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
//        buildOrganization(rootDepartment);
//    }
//
//    private void buildOrganization(Department department) {
//        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
//        for (Long subDepartmentId : subDepartmentIds) {
//            Department subDepartment = new Department(subDepartmentId);
//            department.addSubNode(subDepartment);
//            buildOrganization(subDepartment);
//        }
//        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
//        for (Long employeeId : employeeIds) {
//            double salary = employeeRepo.getEmployeeSalary(employeeId);
//            department.addSubNode(new Employee(employeeId, salary));
//        }
//    }
//}