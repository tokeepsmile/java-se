package com.wangwei.datastructure.sort;



/**
 * @auther wangwei
 * @date 2019-05-12 15:19
 */
public class SortTest {
    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(arr[i] + ",");
            else
                System.out.println(arr[i] + "]");
        }
    }


    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; --j){
                if (arr[j] > value){
                    arr[j+1] = arr[j];
                }else
                    break;
            }

            arr[j+1] = value;
        }
    }

    public static void main(String[] args) {

        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};
        printArr(arr);

        insertSort(arr);
//        bubbleSort(arr);


//        Arrays.sort(arr);
        printArr(arr);
    }
}
