package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/29 20:35
 */
public class _226_Invert_Binary_Tree {

  /*  Invert a binary tree.

    Example:

    Input:

              4
            /   \
          2      7
         / \    / \
        1   3  6   9
    Output:

             4
           /   \
          7     2
         / \   / \
        9   6 3   1

    */



    /**
     * 翻转二叉树 往底层递归前先交换左右孩子
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

       root.left =  invertTree(root.left);
       root.right =  invertTree(root.right);

        return root;
    }

}
