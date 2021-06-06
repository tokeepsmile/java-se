package com.wangwei.javase.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @Author wangwei
 * @Date 2020/11/11 7:57 下午
 * @Version 1.0
 */
public class ClassUtil {

    public static void printAllMethodsByObj(Object object){
        Class<?> aClass = object.getClass();
        //Method[] methods = aClass.getMethods();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            String returtType = returnType.getSimpleName();
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < parameterTypes.length; i++) {
                String parameterTypeName = parameterTypes[i].getSimpleName();
                if (i == parameterTypes.length-1){
                    stringBuilder.append(parameterTypeName);
                }else {
                    stringBuilder.append(parameterTypeName).append(", ");
                }
            }
            System.out.println(returtType + " " + name + "(" + stringBuilder.toString()+")");
        }
    }

    public static void printAllFieldByObj(Object object){
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Type genericType = fields[i].getGenericType();
            String typeName = genericType.getTypeName();
            String fieldName = fields[i].getName();
            System.out.println(typeName + " " + fieldName);
        }
    }
}
