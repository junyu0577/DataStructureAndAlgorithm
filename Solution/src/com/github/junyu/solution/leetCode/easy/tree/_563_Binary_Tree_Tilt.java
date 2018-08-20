package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _563_Binary_Tree_Tilt {

   /* Given a binary tree, return the tilt of the whole tree.

    The tilt of a tree node is defined as the absolute difference between
    the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

    The tilt of the whole tree is defined as the sum of all nodes' tilt.

    Example:
    Input:
            1
            /   \
            2     3
    Output: 1
    Explanation:
    Tilt of node 2 : 0
    Tilt of node 3 : 0
    Tilt of node 1 : |2-3| = 1
    Tilt of binary tree : 0 + 0 + 1 = 1
    Note:

    The sum of node values in any subtree won't exceed the range of 32-bit integer.
    All the tilt values won't exceed the range of 32-bit integer.*/

    private int res = 0;

    /**
     * 求树的坡度，当前结点的坡度的计算规则就是左子树节点总和的和右子树节点的总和的 差的绝对值，空节点的val默认为0，那么树的整体坡度就是各个坡度的sum
     * 使用后序遍历把问题分为两步，第一步是分别求出left和right子树的sum,然后计算坡度
     *
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        countTilt(root);
        return res;
    }

    private int countTilt(TreeNode root) {
        if (root == null)
            return 0;

        int left = countTilt(root.left);
        int right = countTilt(root.right);

        res += Math.abs(left - right);

        return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;

        _563_Binary_Tree_Tilt binary_tree_tilt = new _563_Binary_Tree_Tilt();
        System.out.println(binary_tree_tilt.findTilt(treeNode));
    }

}
