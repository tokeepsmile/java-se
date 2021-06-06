package com.wangwei.javase.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/12/24 上午10:02
 * @Version 1.0
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int i = 0;
        if (i == 0){
            try {
                throw new FileNotFoundException("i");
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
            } catch (Exception e){
                System.out.println("Exception");
            }
        }
    }
}
