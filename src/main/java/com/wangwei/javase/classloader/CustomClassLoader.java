package com.wangwei.javase.classloader;

import java.io.FileNotFoundException;

/**
 * @Author wangwei
 * @Date 2020/12/10 上午11:33
 * @Version 1.0
 */
public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null){
                throw new FileNotFoundException();
            }else {
                return defineClass(name, result, 0, result.length);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new ClassNotFoundException();
    }

    private byte[] getClassFromCustomPath(String name){
        return null;
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("One", true, customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
