package com.wangwei.datastructure.array.leetcode.exer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @auther wangwei
 * @date 2019-06-14 09:56
 *  * 给定两个数组，编写一个函数来计算它们的交集。
 *  *
 *  * 示例 1:
 *  *
 *  * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 *  * 输出: [2,2]
 *  * 示例 2:
 *  *
 *  * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *  * 输出: [4,9]
 *  * 说明：
 *  *
 *  * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *  * 我们可以不考虑输出结果的顺序。
 *  * 进阶:
 *  *
 *  * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 *  * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *  * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class SolutionExer1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums1) {
            if (!treeMap.containsKey(num))
                treeMap.put(num, 1);
            else
                treeMap.put(num, treeMap.get(num)+1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (treeMap.containsKey(num)){
                list.add(num);
                treeMap.put(num, treeMap.get(num)-1);
                if (treeMap.get(num) == 0)
                    treeMap.remove(num);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
//      int[]  nums1 = new int[]{1,2,2,1};
//      int[]  nums2 = new int[]{2,2};
      int[]  nums1 = new int[]{4,9,5};
      int[]  nums2 = new int[]{9,4,9,8,4};

        int[] arr = new SolutionExer1().intersect(nums1, nums2);

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1)
                System.out.print(arr[i] + ",");
            else
                System.out.print(arr[i]+"]");
        }


    }
}
