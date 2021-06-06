package com.wangwei.javase.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/3 9:26 上午
 * @Version 1.0
 */
public class ListDemo {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add("one");
        a1.add(88);
        a1.add(new Object());

        List<Object> a2 = a1;

        for (Object o : a2) {
            System.out.println(o);
        }

        List<Integer> a3 = a1;
        a3.forEach(o -> System.out.println(o));
    }
}
