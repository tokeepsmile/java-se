package com.wangwei.csv;

/**
 * @author: wangwei
 * @date: 2019-07-02 16:04
 */
public class LpqdSum {
    /*索赔日期*/
    private String claimDate;

    /*索赔金额*/
    private String claimAmount;

    /*理赔打款日期*/
    private String claimPaymentDate;

    /*理赔金额*/
    private String claimSum;

    /*划扣金额*/
    private String deductionAmount;

    /*结余理赔金额*/
    private String balanceClaimAmount;

    public LpqdSum() {
    }

    public LpqdSum(String claimDate, String claimAmount, String claimPaymentDate, String claimSum, String deductionAmount, String balanceClaimAmount) {
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.claimPaymentDate = claimPaymentDate;
        this.claimSum = claimSum;
        this.deductionAmount = deductionAmount;
        this.balanceClaimAmount = balanceClaimAmount;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(String claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimPaymentDate() {
        return claimPaymentDate;
    }

    public void setClaimPaymentDate(String claimPaymentDate) {
        this.claimPaymentDate = claimPaymentDate;
    }

    public String getClaimSum() {
        return claimSum;
    }

    public void setClaimSum(String claimSum) {
        this.claimSum = claimSum;
    }

    public String getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(String deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public String getBalanceClaimAmount() {
        return balanceClaimAmount;
    }

    public void setBalanceClaimAmount(String balanceClaimAmount) {
        this.balanceClaimAmount = balanceClaimAmount;
    }
}
