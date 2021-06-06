package com.wangwei.effectivejava.build;

/**
 * @auther wangwei
 * @date 2019-05-26 18:07
 */
public class Demo {
    public static void main(String[] args) {
        Employ employee = new Employ.Builder("wangwei", 18)
                .salary(18000)
//                .sex("男")
                .build();

        System.out.println(employee);

    }
}
