package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _783_Minimum_Distance_Between_BST_Nodes {

   /* Given a Binary Search Tree (BST) with the root node root, return the minimum difference
    between the values of any two different nodes in the tree.

    Example :

    Input: root = [4,2,6,1,3,null,null]
    Output: 1
    Explanation:
    Note that root is a TreeNode object, not an array.

    The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

            4
            /   \
            2      6
            / \
            1   3

            while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also
            between node 3 and node 2.

    Note:

    The size of the BST will be between 2 and 100.
    The BST is always valid, each node's value is an integer, and each node's value is different.
    This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/*/

    private int lastVal = -1;
    private int min = Integer.MAX_VALUE;

    /**
     * 二叉搜索树的最小绝对差
     * 思路：通过中序遍历，使得元素按升序排列，然后计算当前元素与上一个元素的绝对差，并与min进行比较取较小的。
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root){
        if (root==null)
            return;

        inOrder(root.left);
        if (lastVal!=-1)
            min = Math.min(min, Math.abs(root.val-lastVal));
        lastVal = root.val;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        _783_Minimum_Distance_Between_BST_Nodes test = new _783_Minimum_Distance_Between_BST_Nodes();
        System.out.println(test.minDiffInBST(TreeMaker.array2BinaryTree(new Integer[]{4, 2, 6, 1, 3, null, null})));
    }
}
