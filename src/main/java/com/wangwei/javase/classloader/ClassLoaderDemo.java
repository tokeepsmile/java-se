package com.wangwei.javase.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Author wangwei
 * @Date 2020/12/10 上午11:05
 * @Version 1.0
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();

        System.out.println(classLoader);

        ClassLoader parent1 = classLoader.getParent();
        System.out.println(parent1);

        ClassLoader parent2 = parent1.getParent();
        System.out.println(parent2);

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
    }
}
