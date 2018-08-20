package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515_Find_Largest_Value_in_Each_Tree_Row {

   /* You need to find the largest value in each row of a binary tree.

    Example:
    Input:

            1
            / \
            3   2
            / \   \
            5   3   9

    Output: [1, 3, 9]*/

    /**
     * 找到每一层的最大的值
     * bfs，思路同513，就是在遍历层的时候找出最大值，加入到res集合
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                if (cur.val > max)
                    max = cur.val;
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode2.left = treeNode3;

        _515_Find_Largest_Value_in_Each_Tree_Row find_largest_value_in_each_tree_row = new _515_Find_Largest_Value_in_Each_Tree_Row();
        System.out.println(find_largest_value_in_each_tree_row.largestValues(treeNode));
    }
}
