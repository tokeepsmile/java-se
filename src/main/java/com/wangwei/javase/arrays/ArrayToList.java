package com.wangwei.javase.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/3 10:34 下午
 * @Version 1.0
 */
public class ArrayToList {
    public static void main(String[] args) {
        String[] strArray = new String[3];
        strArray[0] = "one";
        strArray[1] = "two";
        strArray[2] = "three";
        for (String s : strArray) {
            System.out.println(s);
        }
        List<String> asList = Arrays.asList(strArray);
        asList.set(1, "two2");
        System.out.println(strArray[1]);
        // 以下会报错 UnsupportedOperationException 因为asList（）返回的是Arrays内部的arraylist并没有实现这些方法
        asList.add("four");
        asList.remove(2);
        asList.clear();
    }
}
