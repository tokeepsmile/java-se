package com.wangwei.datastructure.test;

import com.wangwei.datastructure.tree.bst.BST;

/**
 * @Author wangwei
 * @Date 2021/4/7 6:53 下午
 * @Version 1.0
 */
public class BstDmeo {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};
        BST<Integer> bst = new BST<>();
        for (int num : nums) {
            bst.add(num);
        }
        //System.out.println("min = " + bst.minmum());
        //System.out.println("max = " + bst.maxmumNR());
        //System.out.println("max = " + bst.maxmum());
        bst.preOrder();
        System.out.println("===========");
        //bst.inOrder();
        bst.removeMin();
        bst.preOrder();
        System.out.println("------------");
        //bst.preOrderNR();
        //bst.levelOrder();
        //bst.afterOrder();
        //System.out.println(bst);
    }
}
