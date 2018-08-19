package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.Node;

public class _559_Maximum_Depth_of_N_ary_Tree {
/*
    Given a n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from
    the root node down to the farthest leaf node.

    For example, given a 3-ary tree:


    We should return its max depth, which is 3.

    Note:

    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.*/


    private int max = 0;

    /**
     * 求n叉树的深度
     * 递归的时候和二叉树的区别就是n叉树不是对左右子节点做递归而是对list的每一个元素做递归。
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        countDepth(root, 0);

        return max;
    }

    private void countDepth(Node root, int depth) {
        if (root == null)
            return;

        depth++;
        if (depth > max)
            max = depth;

        for (int i = 0; i < root.children.size(); i++) {
            countDepth(root.children.get(i), depth);
        }
    }
}
