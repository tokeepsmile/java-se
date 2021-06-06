package com.wangwei.javase.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/3 10:34 下午
 * @Version 1.0
 * 数组转集合注意 add等异常
 */
public class ArrayToList2 {
    public static void main(String[] args) {
        String[] strArray = new String[3];
        strArray[0] = "one";
        strArray[1] = "two";
        strArray[2] = "three";
        for (String s : strArray) {
            System.out.println(s);
        }
        // 避免添加元素报错 UnsupportedOperationException
        ArrayList<Object> list = new ArrayList<>(Arrays.asList(strArray));
        list.set(0, "one1");
        list.add("for");
        list.remove(1);
        for (Object o : list) {
            System.out.println(o);
        }
        list.clear();
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
