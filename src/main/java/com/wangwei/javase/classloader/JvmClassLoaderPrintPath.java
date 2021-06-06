package com.wangwei.javase.classloader;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2020/9/22 5:45 下午
 * @Version 1.0
 */
public class JvmClassLoaderPrintPath {
    public static void main(String[] args) {
        // 启动类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();

        System.out.println("启动类加载器");

        for (URL urL : urLs) {
            System.out.println(" ==> " + urL.toExternalForm());
        }

        // 扩展类加载器
        printClassLoader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        // 应用类加载器
        printClassLoader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }


    public static void printClassLoader(String name, ClassLoader cl) {
        if (Objects.nonNull(cl)) {
            System.out.println(name + "ClassLoader -> " + cl.toString());
            printURLForClassLoader(cl);
        } else {
            System.out.println(name + " ClassLoader ‐> null");
        }
    }

    public static void printURLForClassLoader(ClassLoader cl) {
        Object ucp = insightField(cl, "ucp");
        Object path = insightField(ucp, "path");
        ArrayList ps = (ArrayList) path;

        for (Object p : ps) {
            System.out.println(" ==> " + p.toString());
        }
    }

    private static Object insightField(Object obj, String fName) {
        try {
            Field f = null;
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
