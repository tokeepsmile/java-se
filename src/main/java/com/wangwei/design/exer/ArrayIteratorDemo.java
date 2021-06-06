package com.wangwei.design.exer;

import com.wangwei.design.pattern.behavior.iterator.ArrayIterator;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2021/4/6 1:32 下午
 * @Version 1.0
 */
public class ArrayIteratorDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        ArrayList<String> names = new ArrayList<>();
        names.add("wangewi");
        names.add("xiaoming");
        names.add("dabai");

        ArrayIterator<String> iterator = new ArrayIterator<>(names);
        System.out.println(names.size());
        while (iterator.hasNext()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
