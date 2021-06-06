package com.wangwei.datastructure.sort;

/**
 * @auther wangwei
 * @date 2019-05-12 15:17
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length - x - 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }
    }
}
