package com.wangwei.javase.thread.bank;

import java.math.BigDecimal;

/**
 * @Author wangwei
 * @Date 2021/1/14 下午3:34
 * @Version 1.0
 */
public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account();
        a.deposit(new BigDecimal(200));
        System.out.println("A账户余额: " + a.balance());

        Account b = new Account();
        b.deposit(new BigDecimal(200));
        System.out.println("B账户余额: " + b.balance());

        Account c = new Account();
        c.deposit(new BigDecimal(200));
        System.out.println("C账户余额: " + b.balance());

        Thread t1 = new Thread(() -> {
            a.transfer(b, new BigDecimal(100));
        });

        Thread t2 = new Thread(() -> {
            b.transfer(c, new BigDecimal(100));
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("A账户余额: " + a.balance());
        System.out.println("B账户余额: " + b.balance());
        System.out.println("C账户余额: " + c.balance());
    }
}
