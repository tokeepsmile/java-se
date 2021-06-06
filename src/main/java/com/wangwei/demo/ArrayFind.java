package com.wangwei.demo;

public class ArrayFind {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};

        int[] arr2 = new int[]{2, 5, 7, 9, 32, 45, 56, 78, 97, 99};


        System.out.println(halfSearch_2(arr2, 9));

    }


    public static int contains(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 折半查找
     *
     * @param arr
     * @param key
     * @return
     */
    public static int halfSearch(int[] arr, int key) {
        int min, max, mid;
        min = 0;
        max = arr.length - 1;
        mid = (max + min) / 2;
        while (arr[mid] != key) {
            if (arr[mid] > key)
                max = mid - 1;
            else if (arr[mid] < key)
                min = mid + 1;
            if (min > max)
                return -1;
            mid = (max + min) / 2;
        }
        return mid;
    }


    /**
     * 折半查找的第二种方式
     *
     * @param arr
     * @param key
     * @return
     */
    public static int halfSearch_2(int[] arr, int key) {
        int min = 0, max = arr.length - 1, mid;
        while (min <= max) {
            mid = (max + min) / 2;
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
