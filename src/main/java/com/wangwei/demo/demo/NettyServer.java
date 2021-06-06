package com.wangwei.demo.demo;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class NettyServer {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        System.out.println(System.getProperty("ssl"));

        Set<Object> set = properties.keySet();
        Iterator<Object> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString() + ":" + properties.getProperty(iterator.next().toString()));
        }


    }
}
