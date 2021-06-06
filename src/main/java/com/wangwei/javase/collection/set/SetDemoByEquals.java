package com.wangwei.javase.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author wangwei
 * @Date 2021/3/27 下午1:44
 * @Version 1.0
 */
public class SetDemoByEquals {
    public static void main(String[] args) {
        Set<EqualsObject> set = new HashSet<>();
        EqualsObject e1 = new EqualsObject(1, "one");
        EqualsObject e2 = new EqualsObject(1, "one");
        EqualsObject e3 = new EqualsObject(1, "one");
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println(set.size());
        Arrays.asList(set).stream().forEach(x -> System.out.println(x));
    }
}
