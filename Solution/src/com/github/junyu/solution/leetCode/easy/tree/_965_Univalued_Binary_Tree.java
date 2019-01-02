package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _965_Univalued_Binary_Tree {

   /* A binary tree is univalued if every node in the tree has the same value.

            Return true if and only if the given tree is univalued.

            Example 1:

    Input: [1,1,1,1,1,null,1]
    Output: true
    Example 2:


    Input: [2,2,2,5,2]
    Output: false


    Note:

    The number of nodes in the given tree will be in the range [1, 100].
    Each node's value will be an integer in the range [0, 99].*/


    /**
     * 检验二叉树是否都是相同的元素
     * 前序遍历，每次将当前元素和parent的值进行比较，如果不同就返回false。
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        return verifyTree(root,root.val);
    }

    public boolean verifyTree(TreeNode root, int parentValue) {
        if (root==null)
            return true;

        if (root.val!=parentValue)
            return false;

        return verifyTree(root.left,root.val) && verifyTree(root.right,root.val);
    }

    public static void main(String [] args) {
        _965_Univalued_Binary_Tree univalued_binary_tree = new _965_Univalued_Binary_Tree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        System.out.println(univalued_binary_tree.isUnivalTree(treeNode));
    }
}
