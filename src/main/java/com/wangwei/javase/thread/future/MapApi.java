package com.wangwei.javase.thread.future;

/**
 * @Author wangwei
 * @Date 2021/2/2 上午10:54
 * @Version 1.0
 */
public class MapApi {
    public static Integer addressCastNumber(String spiName){
        switch (spiName){
            case "gaode":
                //SleepUtils.second(1);
                return 1;
            case "baidu":
                //SleepUtils.second(2);
                return 2;
            case "tengxun":
                //SleepUtils.second(3);
                return 3;
            default:
                //SleepUtils.second(10);
                return -1;
        }
    }
}
