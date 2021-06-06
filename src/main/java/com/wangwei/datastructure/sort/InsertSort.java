package com.wangwei.datastructure.sort;

/**
 * @auther wangwei
 * @date 2019-05-12 15:17
 */
public class InsertSort {
    // 插入排序，a 表示数组，n 表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }


    public static void sortDemo(int[] arr){
        int length = arr.length;
        if (length <= 1)return;
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j>=0; j--){
                if (arr[j] > value){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }
}
