package com.wangwei.javase.thread.test;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2021/3/25 下午7:12
 * @Version 1.0
 */
public class RemainingDemo {

    private List<String> pool = new ArrayList();
    public static void main(String[] args) throws InterruptedException {
        RemainingDemo remainingDemo = new RemainingDemo();
        remainingDemo.result(1000);

        List list = remainingDemo.get(1000);

        System.out.println(list);

    }


    public List get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        while (pool.isEmpty() && remaining > 0){
            wait(remaining);
            remaining = future - System.currentTimeMillis();
        }
        List result = null;
        if (!pool.isEmpty()){
            result = pool;
        }
        return result;
    }

    public String result(long mils){
        //long future = System.currentTimeMillis() + mils;
        //while (future - System.currentTimeMillis() <= 0){
        //    return null;
        //}
        SleepUtils.second(3);
        pool.add("name");
        return "处理失败";
    }

}
