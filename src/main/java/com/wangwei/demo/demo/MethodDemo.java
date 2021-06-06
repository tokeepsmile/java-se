package com.wangwei.demo.demo;

public class MethodDemo {
    public static void main(String[] args) {

        invoke(null, 1);
        invoke(null, 1, 2);

    }


    public static void invoke(Object obj, Object... args) {
        System.out.println("第一个方法");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println(obj.toString());
    }

    public static void invoke(String s, Object obj, Object... args) {
        System.out.println("第二个方法");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println(s);
        System.out.println(obj.toString());
    }

//    invoke(null, 1);    // 调用第二个 invoke 方法
//    invoke(null, 1, 2); // 调用第二个 invoke 方法
//    invoke(null, new Object[]{1}); // 只有手动绕开可变长参数的语法糖，
//    // 才能调用第一个 invoke 方法


}
