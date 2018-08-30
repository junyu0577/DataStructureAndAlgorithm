package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class _111_Minimum_Depth_of_Binary_Tree {


   /* Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

            3
            / \
            9  20
            /  \
            15   7
            return its minimum depth = 2.*/

    /**
     * 求树的最小深度，也就是求一条根到叶子的最短距离
     * 用层序遍历，当遍历到某一层的时候，其左右孩子都为null时，那么当前层即为最小的深度。
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int count = 1;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode temp = q.removeFirst();
                if (temp.left == null && temp.right == null)
                    return count;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
//        treeNode3.left = treeNode5;
        System.out.println(new _111_Minimum_Depth_of_Binary_Tree().minDepth(treeNode));
    }
}
