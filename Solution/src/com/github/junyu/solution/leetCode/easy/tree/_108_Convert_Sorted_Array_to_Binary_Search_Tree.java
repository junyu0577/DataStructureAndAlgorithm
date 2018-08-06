package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/28 18:26
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

 /*   Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example:

    Given the sorted array: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

            0
            / \
            -3   9
            /   /
            -10  5*/



    public static TreeNode sortedArrayToBST(int[] nums) {
        return generateBst(nums, 0, nums.length - 1);
    }

    /**
     * 提前是有序的数组
     * 将数组以中间为分割点进行拆分，然后利用递归进行左右孩子的添加
     *
     * @param nums
     * @return
     */
    private static TreeNode generateBst(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generateBst(nums, left, mid - 1);
        node.right = generateBst(nums, mid + 1, right);
        return node;
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 5};
        TreeNode node = sortedArrayToBST(arr);
        System.out.println(node);
    }

}
