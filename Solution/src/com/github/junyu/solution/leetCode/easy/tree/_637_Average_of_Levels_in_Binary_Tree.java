package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _637_Average_of_Levels_in_Binary_Tree {


/*
    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
            Example 1:
    Input:
            3
            / \
            9  20
            /  \
            15   7
    Output: [3, 14.5, 11]
    Explanation:
    The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
    Note:
    The range of node's value is in the range of 32-bit signed integer.
    */


    /**
     * 求一层的平均值
     * 用层序遍历求解
     *
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> list = new LinkedList();
        list.add(root);

        while (!list.isEmpty()) {
            int length = list.size();
            double count = 0;
            for (int i = 0; i < length; i++) {
                TreeNode temp = list.removeFirst();

                if (temp.left != null)
                    list.add(temp.left);

                if (temp.right != null)
                    list.add(temp.right);

                count += temp.val;
            }
            if (length != 0) {
                res.add(count / length);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(9);
//        TreeNode treeNode3 = new TreeNode(20);
//        TreeNode treeNode4 = new TreeNode(15);
//        TreeNode treeNode5 = new TreeNode(7);
//
//        treeNode.left = treeNode2;
//        treeNode.right = treeNode3;
//
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;

        _637_Average_of_Levels_in_Binary_Tree average_of_levels_in_binary_tree = new _637_Average_of_Levels_in_Binary_Tree();
        System.out.println(average_of_levels_in_binary_tree.averageOfLevels(treeNode));
    }


}
