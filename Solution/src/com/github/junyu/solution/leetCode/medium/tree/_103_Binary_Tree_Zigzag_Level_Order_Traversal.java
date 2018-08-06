package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShaoJunyu
 * @since 2018/8/3 09:56
 */
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

/*
    Given a binary tree, return the zigzag level order traversal of its nodes'
            values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
            / \
            9  20
            /  \
            15   7
            return its zigzag level order traversal as:
            [
            [3],
            [20,9],
            [15,7]
            ]
    */


    /**
     * 这题就是之前层序遍历的基础之上，增加了正序和反序存储，
     * 关键点就是在childList增加元素前看看当前层是否需要倒过来输出，如果需要，那么
     * 每次增加的时候就往第0个位置去插入
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        boolean needRev = false;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int length =  q.size();

            List<Integer> childList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = q.remove();

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);

                if (needRev)
                    childList.add(0,node.val);
                else
                    childList.add(node.val);
            }

            if (childList.size() != 0)
                list.add(childList);

            needRev = !needRev;

        }

        return list;
    }

    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;

        _103_Binary_Tree_Zigzag_Level_Order_Traversal binary_tree_zigzag_level_order_traversal = new _103_Binary_Tree_Zigzag_Level_Order_Traversal();
        List<List<Integer>> list = binary_tree_zigzag_level_order_traversal.zigzagLevelOrder(treeNode);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

}
