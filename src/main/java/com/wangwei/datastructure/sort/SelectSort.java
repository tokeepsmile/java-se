package com.wangwei.datastructure.sort;

/**
 * @auther wangwei
 * @date 2019-05-12 15:18
 */
public class SelectSort {

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;

                }
            }
        }
    }
}
