package com.wangwei.javase.thread.bank;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author wangwei
 * @Date 2021/1/14 下午3:22
 * @Version 1.0
 */
public class VirtualWallet {
    private String id = UUID.randomUUID().toString();
    private BigDecimal balance = BigDecimal.ZERO;
    private long createTime = System.currentTimeMillis();

    public BigDecimal balance(){
        return this.balance;
    }

    // 提现/支付
    public void debit(BigDecimal amount){
        if (this.balance.compareTo(amount) < 0){
            throw new UnsupportedOperationException("余额不足");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new UnsupportedOperationException("金额非法");
        }
        this.balance = this.balance.add(amount);
    }
}
