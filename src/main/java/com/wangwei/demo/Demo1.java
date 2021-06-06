package com.wangwei.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther wangwei
 * @Date 2018/4/26 下午5:52
 */
public class Demo1 {

    public static void main(String[] args) {
        List a = null;
        new Demo1().test(a);
        System.out.println(a.size());

    }

    public void test(List a) {
        a = new ArrayList();
        a.add(1);

    }
}
