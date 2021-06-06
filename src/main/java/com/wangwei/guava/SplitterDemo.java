package com.wangwei.guava;

import com.google.common.base.Splitter;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/12/11 下午5:02
 * @Version 1.0
 */
public class SplitterDemo {
    public static void main(String[] args) {
        String str = ",a,,b,";
        String[] split = str.split(",");
        System.out.println(Arrays.asList(split));

        System.out.println(Splitter.on(",").splitToList(str));

        System.out.println(Splitter.on(",").omitEmptyStrings().splitToList(str));

        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str));

        String ipStr = "10.100.122.2";
        List<String> list = Splitter.on(".").trimResults().splitToList(ipStr);
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(Integer.toBinaryString(Integer.parseInt(s))).append(".");
        }
        System.out.println(list);
        System.out.println(builder.toString());
        System.out.println(Splitter.on(".").trimResults().omitEmptyStrings().splitToList(builder.toString()));
    }
}
