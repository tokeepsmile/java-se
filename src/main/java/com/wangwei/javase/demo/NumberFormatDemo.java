package com.wangwei.javase.demo;

import java.text.NumberFormat;

/**
 * @auther wangwei
 * @date 2019-05-18 21:55
 */
public class NumberFormatDemo {

    public static void main(String[] args) {

        double x = 0.11;

        NumberFormat percentInstance = NumberFormat.getPercentInstance();

        System.out.println(percentInstance.format(x));

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();

        System.out.println(currencyInstance.format(x));

    }
}
