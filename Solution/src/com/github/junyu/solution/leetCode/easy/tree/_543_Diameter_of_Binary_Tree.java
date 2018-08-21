package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _543_Diameter_of_Binary_Tree {


  /*  Given a binary tree, you need to compute the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    This path may or may not pass through the root.

    Example:
    Given a binary tree
                   1
                  / \
                 2   3
                / \
               4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.*/

    private int max = 0;

    /**
     * 求树的直径，也就是求树中两个节点之间的最大距离
     * 其实这题就是转换一下思路就是求树种左子树与右子树的最大深度的和
     * 后序遍历，在回溯时总是返回左右子树中最大的深度
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(11);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;

        _543_Diameter_of_Binary_Tree diameter_of_binary_tree = new _543_Diameter_of_Binary_Tree();
        System.out.println(diameter_of_binary_tree.diameterOfBinaryTree(treeNode));
    }

}
