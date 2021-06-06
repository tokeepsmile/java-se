package com.wangwei.javase.collection.generic;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/4/3 11:31 下午
 * @Version 1.0
 */
public class ListNoGeneric {
    public static void main(String[] args) {
        // 泛型出现之前的集合定义方式
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(111));
        a1.add("hello a1a1");

        // 把a1引用赋值给a2, a1与a2的区别是增加了泛型限制object
        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add("hello a2a2");

        // 把a1引用赋值给a3, a1与a3的区别是增加了泛型限制integer
        List<Integer> a3 = a1;
        a3.add(new Integer(333));
        //l3.add(new Object());

        // 把a1引用赋值给a4, a1与a4的区别是增加了通配符
        List<?> a4 = a1;
        a4.remove(0);
        a4.clear();

        // 编译出错，不允许增加任何元素
        //l4.add(new Object());



    }
}
