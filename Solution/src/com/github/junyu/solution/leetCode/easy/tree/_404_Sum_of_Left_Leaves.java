package com.github.junyu.solution.leetCode.easy.tree;


import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class _404_Sum_of_Left_Leaves {

/*
    Find the sum of all left leaves in a given binary tree.

    Example:

            3
            / \
            9  20
            /  \
            15   7

    There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
    */


//    /**
//     * 用层序遍历求解，在往队列中添加元素的时候判断左孩子时进行累加。
//     * 但是要注意=-=，左孩子必须是叶子节点
//     *
//     * @param root
//     * @return
//     */
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        LinkedList<TreeNode> list = new LinkedList<>();
//        list.add(root);
//
//        int res = 0;
//
//        while (!list.isEmpty()) {
//            TreeNode node = list.removeFirst();
//            if (node.left != null) {
//
//                if (node.left.left == null && node.left.right == null)//只有叶子节点才计入
//                    res += node.left.val;
//
//                list.add(node.left);
//            }
//            if (node.right != null) {
//                list.add(node.right);
//            }
//        }
//        return res;
//
//    }

    private int res = 0;

    /**
     * 前序遍历，多传入一个参数标识是否为左孩子
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        sumOfLeftLeaves(root, false);
        return res;

    }

    private void sumOfLeftLeaves(TreeNode node, boolean isLeftChild) {
        if (node == null)
            return;


        if (node.left == null && node.right == null && isLeftChild)//左边的叶子节点
            res += node.val;

        sumOfLeftLeaves(node.left, true);
        sumOfLeftLeaves(node.right, false);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode.left.left = treeNode4;

        _404_Sum_of_Left_Leaves sum_of_left_leaves = new _404_Sum_of_Left_Leaves();
        System.out.println(sum_of_left_leaves.sumOfLeftLeaves(treeNode));
    }

}
