package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _112_Path_Sum {

   /*
    Given a binary tree and a sum, determine if the tree has a
        root-to-leaf path such that adding up all the values along the path equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

            5
            / \
            4   8
            /   / \
            11  13  4
            /  \      \
            7    2      1
            return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    */



    /**
     * 计算从root到leaf的单一路径的sum和传入的sum是否相等，相等就返回
     * 这题和257太像了，只不过本题是求和后判断和sum相等，而257是输出路径
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return compute(root, sum, 0);
    }

    private boolean compute(TreeNode node, int sum, int val) {
        if (node == null) {
            return false;
        }

        val += node.val;

        if (node.left == null && node.right == null) {
            if (sum == val)
               return true;
        }

        return compute(node.left, sum, val) ||
                compute(node.right, sum, val);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode4.left = treeNode5;

        _112_Path_Sum path_sum = new _112_Path_Sum();
        System.out.println(path_sum.hasPathSum(treeNode, 15));
    }

}
