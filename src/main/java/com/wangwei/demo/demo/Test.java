package com.wangwei.demo.demo;

import static java.lang.Float.NaN;

public class Test {
    public static void main(String[] args) {
        System.out.println(+0.0f == -0.0F);
        System.out.println(+0.0f);
        System.out.println(+0.0f / +0.0f);

        System.out.println(NaN > 0);

        System.out.println(NaN < 0);

        System.out.println(NaN != 0);
    }
}
