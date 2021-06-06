package com.wangwei.csv;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangwei
 * @date: 2019-07-02 16:06
 */
public class Demo {
    public static void main(String[] args) {

        Object[] fileHeader = {"索赔日期", "索赔金额", "理赔打款日期", "理赔金额", "划扣金额", "结余理赔金额"};

        LocalDate now = LocalDate.now();
        String date = now.minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        File file = new File("lpqd_sum_" + date + ".txt");
        List<LpqdSum> list = new ArrayList<>();
        LpqdSum lpqdSum1 = new LpqdSum(now.format(DateTimeFormatter.ISO_LOCAL_DATE), String.valueOf(BigDecimal.ZERO), date, String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO));
        LpqdSum lpqdSum2 = new LpqdSum(now.format(DateTimeFormatter.ISO_LOCAL_DATE), String.valueOf(BigDecimal.ZERO), date, String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO));
        LpqdSum lpqdSum3 = new LpqdSum(now.format(DateTimeFormatter.ISO_LOCAL_DATE), String.valueOf(BigDecimal.ZERO), date, String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO));
        LpqdSum lpqdSum4 = new LpqdSum(now.format(DateTimeFormatter.ISO_LOCAL_DATE), String.valueOf(BigDecimal.ZERO), date, String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO));
        LpqdSum lpqdSum5 = new LpqdSum(now.format(DateTimeFormatter.ISO_LOCAL_DATE), String.valueOf(BigDecimal.ZERO), date, String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ZERO));

        list.add(lpqdSum1);
        list.add(lpqdSum2);
        list.add(lpqdSum3);
        list.add(lpqdSum4);
        list.add(lpqdSum5);

        /*理赔清单汇总统计，字段值不是对应关系*/
        LpqdSum totalLpqd = new LpqdSum();
        totalLpqd.setClaimDate("汇总");
        BigDecimal claimAmount = BigDecimal.ZERO;
        BigDecimal claimSum = BigDecimal.ZERO;
        BigDecimal deductionAmount = BigDecimal.ZERO;
        BigDecimal balanceClaimAmount = BigDecimal.ZERO;
        for (LpqdSum lpqdSum : list) {
            /*索赔金额汇总*/
            claimAmount = claimAmount.add(new BigDecimal(lpqdSum.getClaimAmount()));
            /*理赔金额汇总*/
            claimSum = claimSum.add(new BigDecimal(lpqdSum.getClaimSum()));
            /*划扣金额汇总*/
            deductionAmount = deductionAmount.add(new BigDecimal(lpqdSum.getDeductionAmount()));
            /*结余理赔金额汇总*/
            balanceClaimAmount = balanceClaimAmount.add(new BigDecimal(lpqdSum.getBalanceClaimAmount()));
        }

        totalLpqd.setClaimAmount(String.valueOf(claimAmount));
        totalLpqd.setClaimPaymentDate("");
        totalLpqd.setClaimSum(String.valueOf(claimSum));
        totalLpqd.setDeductionAmount(String.valueOf(deductionAmount));
        totalLpqd.setBalanceClaimAmount(String.valueOf(balanceClaimAmount));

        list.add(totalLpqd);

       CsvFileWriter.writeCsvFile(file.getAbsolutePath(), fileHeader, list);
    }
}
