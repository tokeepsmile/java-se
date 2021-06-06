package com.wangwei.javase.datatype;

/**
 * @auther wangwei
 * @date 2019-05-18 12:32
 */
public class DoubleDemo {
    public static void main(String[] args) {
        String s = "2";
        System.out.println(Double.isNaN(Double.valueOf(s)));

        double x = 1.0;
        System.out.println(Double.isNaN(x));

        System.out.println(2-1.1);

        System.out.println(1/10);

        int a = 8;

        int d = 8;

        int b = 2 * a++;
        System.out.println("b= " + b + " a= " + a);

        int c = 2 * ++d;
        System.out.println("c= " + c + " d= " + d);

        String name = "wangwei";

        System.out.println(name.indexOf("w"));

        char[] chars = new char[name.length()];
        String[] split = name.split(",", 1);


        System.out.print("[");

        for (int i = 0; i < name.length(); i++) {
            if (i != name.length()-1){
                chars[i] = name.charAt(i);
                System.out.print(chars[i]+",");
            }else {
            chars[i] = name.charAt(i);
            System.out.println(chars[i] + "]");
            }
        }

        System.out.println("chars =" + chars.length);
        String[] strings = chars.toString().split(",");
        System.out.println(strings[0].length());


        String str = String.join("/", "w", "a", "n", "g");
        System.out.println("str=" + str);



    }
}
