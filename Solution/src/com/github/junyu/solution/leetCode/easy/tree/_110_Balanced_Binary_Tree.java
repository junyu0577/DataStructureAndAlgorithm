package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _110_Balanced_Binary_Tree {

 /*   Given a binary tree, determine if it is height-balanced.

            For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example 1:

    Given the following tree [3,9,20,null,null,15,7]:

            3
            / \
            9  20
            /  \
            15   7
    Return true.

    Example 2:

    Given the following tree [1,2,2,3,3,null,null,4,4]:

            1
            / \
            2   2
            / \
            3   3
            / \
            4   4
    Return false.*/

    /**
     * 判断是否是平衡二叉树
     * 在求树的深度的基础上，再判断左右子树的差的绝对值是否大于1，大于1则不平衡。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode.left = treeNode2;
        treeNode2.left = treeNode3;
//        treeNode.right = treeNode3;
//        treeNode2.left = treeNode4;
        System.out.println(new _110_Balanced_Binary_Tree().isBalanced(treeNode));
    }

}
