package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _654_Maximum_Binary_Tree {

/*

    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    Construct the maximum tree by the given array and output the root node of this tree.

            Example 1:
    Input: [3,2,1,6,0,5]
    Output: return the tree root node representing the following tree:

            6
            /   \
            3     5
            \    /
            2  0
            \
            1
    Note:
    The size of the given array will be in the range [1,1000].
*/

    /**
     * 构建最大二叉树，返回root，构建条件如下：
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 思路就是不断的在数组中找到子树的root，然后根据root将数组一分为二，左边的最大值又是子树的root，右边同理
     * 做完这题就可以再试试105，思路是类似的
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int rootIndex = left;
        for (int i = left + 1; i <= right; i++) {//在left和right范围中找最大值
            if (nums[i] >= nums[rootIndex]) {
                rootIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode(nums[rootIndex]);

        treeNode.left = buildTree(nums, left, rootIndex - 1);
        treeNode.right = buildTree(nums, rootIndex + 1, right);

        return treeNode;
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 6, 0, 5};
        _654_Maximum_Binary_Tree maximum_binary_tree = new _654_Maximum_Binary_Tree();
        TreeNode tree = maximum_binary_tree.constructMaximumBinaryTree(arr);
        System.out.println(tree);
    }
}
