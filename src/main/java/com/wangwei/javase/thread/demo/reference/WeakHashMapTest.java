package com.wangwei.javase.thread.demo.reference;

import java.util.WeakHashMap;

/**
 * @Author wangwei
 * @Date 2020/11/24 下午8:54
 * @Version 1.0
 */
public class WeakHashMapTest {
    public static void main(String[] args) {

        House house1 = new House("1号卖家房源");
        SellerInfo sellerInfo1 = new SellerInfo();

        House house2 = new House("2号卖家房源");
        SellerInfo sellerInfo2 = new SellerInfo();
        WeakHashMap<House, SellerInfo> weakHashMap = new WeakHashMap<>();

        weakHashMap.put(house1, sellerInfo1);
        weakHashMap.put(house2, sellerInfo2);
        System.out.println(weakHashMap.size());


        house1 = null;
        System.gc();

        System.runFinalization();

        System.out.println(weakHashMap.size());
    }
}
