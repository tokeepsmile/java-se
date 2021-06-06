package com.wangwei.datastructure.sort;

public class For2Demo {
    public static void main(String[] args) {

        print1();

        print2();

        print3();

    }


    /**
     * *
     * **
     * ***
     * *****
     * ******
     */
    public static void print1() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y <= x; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * *****
     * ****
     * ***
     * **
     * *
     */
    public static void print2() {
//        int z = 5;
//        for (int x=0; x<5; x++){
//            for (int y = 0; y < z; y++){
//                System.out.print("*");
//            }
//            System.out.println();
//            z--;
//        }

        for (int x = 0; x < 5; x++) {
            for (int y = x; y < 5; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * 9*9乘法表
     */
    public static void print3() {
        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(y + "*" + x + "=" + x * y + "\t");
            }
            System.out.println();
        }
    }

}
