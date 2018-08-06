package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

/**
 * @author ShaoJunyu
 * @since 2018/7/25 09:17
 */
public class _104_Maximum_Depth_of_Binary_Tree {

  /*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Note: A leaf is a node with no children.
   */


  /*  Example:

    Given binary tree [3,9,20,null,null,15,7],

            3
            / \
            9  20
            /  \
            15   7
            return its depth = 3.
   */


    /**
     * 采用递归 后序遍历 得出树深
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        maxDepth(treeNode);
    }
}