package com.wangwei.javase.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @auther wangwei
 * @date 2019-05-18 16:55
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        System.out.println("date=" + date);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();
        System.out.println(value);


        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++)
            System.out.print("  ");

        while (date.getMonthValue() == month){
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print("");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();


//        System.out.println(now.toString());
//        int day = now.getDayOfMonth();
//        System.out.println(day);
//
//        System.out.println(now.getYear()+"年/"+now.getMonthValue()+"月/"+now.getDayOfYear());
    }
}
