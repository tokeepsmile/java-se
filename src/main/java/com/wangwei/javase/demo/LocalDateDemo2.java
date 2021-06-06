package com.wangwei.javase.demo;

import java.time.LocalDate;

/**
 * @auther wangwei
 * @date 2019-05-18 17:30
 */
public class LocalDateDemo2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = date.plusDays(1);
        LocalDate date2 = date.minusDays(1);

        System.out.println("tost:" + LocalDate.now().minusDays(1).toString());

        System.out.println("date2:" + date2);
        System.out.println(date1);

        System.out.println(date);

        String str = "wangwei";
        System.out.println(str);

        String s = str.toUpperCase();
        System.out.println(s);

        System.out.println(str);
    }
}
