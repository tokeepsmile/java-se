package com.wangwei.javase.methodparam;

/**
 * @auther wangwei
 * @date 2019-05-19 11:07
 */
public class MethodDemo {

    public static void main(String[] args) {

        double x = 3;

        System.out.println("x=" + x);
        process(x);

        System.out.println("x=" + x);

//        System.out.println("process=" + process);

    }

    public static void process(double x){
        x *= 3;
    }
}
