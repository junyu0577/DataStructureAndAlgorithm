package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _530_Minimum_Absolute_Difference_in_BST {

    /*Given a binary search tree with non-negative values, find the minimum absolute difference
     between values of any two nodes.

    Example:

    Input:

            1
             \
              3
            /
            2

    Output:
            1

    Explanation:
    The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


    Note:

    There are at least two nodes in this BST.
    This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/*/

    private int min = Integer.MAX_VALUE;
    private int lastVal = -1;

    /**
     * 二叉搜索树的最小绝对差
     * 思路：通过中序遍历，使得元素按升序排列，然后计算当前元素与上一个元素的绝对差，并与min进行比较取较小的。
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        if (lastVal!=-1){
            min = Math.min(min,Math.abs(lastVal-root.val));
        }
        lastVal = root.val;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        _530_Minimum_Absolute_Difference_in_BST test = new _530_Minimum_Absolute_Difference_in_BST();
//        System.out.println(test.getMinimumDifference(TreeMaker.array2BinaryTree(new Integer[]{1, null, 3, null, null,
//                2})));
        System.out.println(test.getMinimumDifference(TreeMaker.array2BinaryTree(new Integer[]{236, 104, 701, null,
                227, null, 911})));
    }
}
