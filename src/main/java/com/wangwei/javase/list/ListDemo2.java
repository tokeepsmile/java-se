package com.wangwei.javase.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/3 9:30 上午
 * @Version 1.0
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        //for (Object o : list) {
        //    if (o.equals("two")) {
        //        list.remove(o);
        //    }
        //}

        List subList = list.subList(0, 3);

        for (Object o : subList) {
            System.out.println(o);
        }

        list.remove(2);

        for (Object o : subList) {
            System.out.println(o);
        }
    }
}
