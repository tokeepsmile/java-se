package com.wangwei.javase.thread.concurrency.example.syncContainer;


import com.wangwei.javase.thread.concurrency.annotaions.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by wangwei on 2018/3/27.
 */
@NotThreadSafe
public class VectorExample2 {

    /**
     * Exception in thread "main" java.util.ConcurrentModificationException
     * @param v1
     */
    public static void test1(Vector<Integer> v1){
        for (Integer i : v1) {
            if (i.equals(3)){
                v1.remove(i);
            }
        }
    }


    /**
     * Exception in thread "main" java.util.ConcurrentModificationException
     * @param v1
     */
    public static void test2(Vector<Integer> v1){

        Iterator<Integer> iterator = v1.iterator();

        while (iterator.hasNext()){

            Integer next = iterator.next();

            if (next.equals(3)){
                v1.remove(next);
            }
        }
    }


    public static void test3(Vector<Integer> v1){

        for (int i = 0; i < v1.size(); i++) {

            if (v1.get(i).equals(3)){
                v1.remove(i);
            }
        }

    }


    public static void main(String[] args) {

       Vector<Integer> vector = new Vector<>();

        vector.add(1);
        vector.add(2);
        vector.add(3);

        //test1(vector);
        //test2(vector);
        test3(vector);



    }
}
