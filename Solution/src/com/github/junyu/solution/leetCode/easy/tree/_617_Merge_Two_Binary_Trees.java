package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _617_Merge_Two_Binary_Trees {


  /*  Given two binary trees and imagine that when you put one of them to
    cover the other, some nodes of the two trees are overlapped while the others are not.

    You need to merge them into a new binary tree. The merge rule is that if two
    nodes overlap, then sum node values up as the new value of the merged node.
        Otherwise, the NOT null node will be used as the node of new tree.

            Example 1:
    Input:
    Tree 1                     Tree 2
            1                         2
            / \                       / \
            3   2                     1   3
            /                           \   \
            5                             4   7
    Output:
    Merged tree:
            3
            / \
            4   5
            / \   \
            5   4   7
    Note: The merging process must start from the root nodes of both trees.*/

    /**
     * 合并两个二叉树，如果两个节点都不为空，就让两个节点相加，如果，有一个为空，那么就取不为空的节点
     * 我的策略就是让t2去覆盖t1，如果t1和t2都不为空，那么val就相加，如果仅t2为空，那么就返回t1就好，如果t1
     * 为空，就将t2返回。一共就分别三部，首先处理root的val，直接相加就好，然后分别处理root的left和right。
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        t1.val = t1.val + t2.val;


        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        return t1;
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;

        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
        }

        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }

        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        return t1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(5);

        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode44 = new TreeNode(4);
        TreeNode treeNode77 = new TreeNode(7);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;

        treeNode22.left = treeNode11;
        treeNode22.right = treeNode33;
        treeNode11.right = treeNode44;
        treeNode33.right = treeNode77;


        _617_Merge_Two_Binary_Trees merge_two_binary_trees = new _617_Merge_Two_Binary_Trees();
        TreeNode res = merge_two_binary_trees.mergeTrees(treeNode, treeNode22);
        System.out.println(res);
    }

}
