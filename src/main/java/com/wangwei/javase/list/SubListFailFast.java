package com.wangwei.javase.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/4 12:19 上午
 * @Version 1.0
 */
public class SubListFailFast {
    public static void main(String[] args) {
        List masterList = new ArrayList();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List branchList = masterList.subList(0, 3);

        //masterList.remove(0);
        //masterList.add("ten");
        //masterList.clear();

        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);

        for (Object o : branchList) {
            System.out.println(o);
        }

        System.out.println(masterList);
    }
}
