package com.wangwei.javase.demo;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author wangwei
 * @Date 2020/11/17 下午10:39
 * @Version 1.0
 */
public class GCLogAnalysis {
    private static Random random = new Random();
    public static void main(String[] args){
        long startMills = System.currentTimeMillis();
        // 持续运行毫秒数
        long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
       // 结束时间戳
       long endMills = startMills + timeoutMillis;

        LongAdder counter = new LongAdder();
        System.out.println("正在执行。。。。。。");
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[cacheSize];
        while (System.currentTimeMillis() < endMills) {
            // 生成垃圾对象
            Object garbage = generateGarbage(100*1024);
            counter.increment();
            int randomIndex = random.nextInt(2 * cacheSize);
            if (randomIndex < cacheSize){
                cachedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("执行结束 共生成对象次数:" + counter.longValue());
    }

    // 生成对象
    private static Object generateGarbage(int max) {
        int randomSize = random.nextInt(max);
        int type = randomSize % 4;
        Object result = null;
        switch (type){
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "randomString-Anything";
                while (builder.length() < randomSize){
                    builder.append(randomString);
                    builder.append(max);
                    builder.append(randomSize);
                }
                result = builder.toString();
                break;
        }
        return result;
    }
}
