package com.wangwei.javase.thread.bank;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author wangwei
 * @Date 2021/1/14 下午3:12
 * @Version 1.0
 */
public class Account {
    private BigDecimal balance;
    private String accountId;
    private long createTime;
    private String password;

    public Account() {
        this.balance = BigDecimal.ZERO;
        this.accountId = UUID.randomUUID().toString();
        this.createTime = System.currentTimeMillis();
    }

    public BigDecimal balance() {
        return this.balance;
    }

    // 不安全的只能锁住当前资源
    //public synchronized void transfer(Account targetAccount, BigDecimal amount){
    //    if (this.balance.compareTo(amount) < 0 || amount.compareTo(BigDecimal.ZERO) < 0){
    //        throw new UnsupportedOperationException("余额不足");
    //    }
    //    this.balance = this.balance.subtract(amount);
    //    targetAccount.balance = targetAccount.balance.add(amount);
    //}

    public  void transfer(Account targetAccount, BigDecimal amount){
        synchronized (Account.class){
            if (this.balance.compareTo(amount) < 0 || amount.compareTo(BigDecimal.ZERO) < 0){
                throw new UnsupportedOperationException("余额不足");
            }
            this.balance = this.balance.subtract(amount);
            targetAccount.balance = targetAccount.balance.add(amount);
        }
    }

    public void deposit(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new UnsupportedOperationException("金额非法");
        }
        this.balance = this.balance.add(amount).setScale(2);
    }


    public String getAccountId() {
        return accountId;
    }


    public long getCreateTime() {
        return createTime;
    }


}
