package com.wangwei.javase.param;

/**
 * @Author wangwei
 * @Date 2020/3/31 3:02 下午
 * @Version 1.0
 */
public class ParamPassing {
    private static int intStatic = 222;
    private static String stringStatic = "old String";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old StringBuilder");

    public static void main(String[] args) {
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);

        // 输出依然是 222
        System.out.println(intStatic);

        method();
        // 无参数方法调用之后 反而修改为888
        System.out.println(intStatic);

        // 输出依然是 old String
        System.out.println(stringStatic);

        System.out.println(stringBuilderStatic);
    }

    public static void method(int intStatic){
        intStatic = 777;
    }

    public static void method(){
        intStatic = 888;
    }

    public static void method(String stringStatic){
        stringStatic = "new String";
    }

    public static void method(StringBuilder stringBuilder1, StringBuilder stringBuilder2){
        stringBuilder1.append(".method.first-");
        stringBuilder2.append(".method.second-");
        stringBuilder1 = new StringBuilder("new stringBuilder");
        stringBuilder1.append("new method's append");
    }
}
