package com.wangwei.exer.string;

/**
 * @Author wangwei
 * @Date 2021/4/17 12:13 上午
 * @Version 1.0
 * 编写Java  Application 程序，查找出字符串str中字符A，替换成字符B，并统计替换的次数。【注】不可以使用Java的内置函数，如index()、replace()等。
 *
 * 输入例子1:
 * String str = "dsafanfvapdifiaiogfa";
 * char A = 'a';
 * char B = 'b';
 *
 * Result String:dsbfbnfvbpdifibiogfb
 * A count:5
 */
public class Main {
    public static void main(String[] args){
        replaceStr("dsafanfvapdifiaiogfa");
    }

    public static void replaceStr(String str) {
        char[] arr = str.toCharArray();
        char A = 'a';
        char B = 'b';
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == A) {
                arr[i] = B;
                count++;
            }
        }
        System.out.println("Result String:" + String.valueOf(arr));
        System.out.println("A count:" + count);
    }
}
