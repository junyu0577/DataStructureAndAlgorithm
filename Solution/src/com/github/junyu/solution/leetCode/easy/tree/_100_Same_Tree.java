package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;


public class _100_Same_Tree {

   /* Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are
    structurally identical and the nodes have the same value.

            Example 1:

    Input:     1         1
            / \       / \
            2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true
    Example 2:

    Input:     1         1
            /           \
            2             2

            [1,2],     [1,null,2]

    Output: false
    Example 3:

    Input:     1         1
            / \       / \
            2   1     1   2

            [1,2,1],   [1,1,2]

    Output: false*/


    /**
     * 比较两棵树是否一致
     * 递归分别对左和右进行比较
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(-5);
        TreeNode node4 = new TreeNode(-8);
        node.left = node3;
        node2.left = node4;
        _100_Same_Tree same_tree = new _100_Same_Tree();
        System.out.println(same_tree.isSameTree(node, node2));
    }

}
