package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _513_Find_Bottom_Left_Tree_Value {

/*
    Given a binary tree, find the leftmost value in the last row of the tree.

    Example 1:
    Input:

            2
            / \
            1   3

    Output:
            1
    Example 2:
    Input:

            1
            / \
            2   3
            /   / \
            4   5   6
            /
            7

    Output:
            7
    Note: You may assume the tree (i.e., the given root node) is not NULL.*/

    /**
     * 找到最后一层最左边的叶子节点
     * 用层序遍历，遍历每一层的时候，都将第一个left赋值给lastNode，到最后这个lastNode的val就是要找的叶子节点
     * bfs
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode lastNode = null;
        while (!q.isEmpty()) {
            int len = q.size();
            lastNode = q.peek();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }

        return lastNode.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode2.left = treeNode3;

        _513_Find_Bottom_Left_Tree_Value find_bottom_left_tree_value = new _513_Find_Bottom_Left_Tree_Value();
        System.out.println(find_bottom_left_tree_value.findBottomLeftValue(treeNode));
    }

}
