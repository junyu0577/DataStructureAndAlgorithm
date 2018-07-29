package com.github.junyu.solution.leetCode.easy.tree;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/29 20:57
 */
public class _101_Symmetric_Tree {

   /* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

             1
            / \
           2   2
          / \ / \
          3  4 4  3
    But the following [1,2,2,null,3,null,3] is not:
            1
           / \
          2   2
           \   \
            3    3
        */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 验证树的对称
     *
     * 往下递归的时候分为三种情况
     * 1.要比较的两个节点都为空 对称
     * 2.两个节点有一个不为空 不对称
     * 3.两个节点都不为空，就需要比较值是否相等，并且满足左边的左孩子和右边的后孩子值相等，
     * 左边的右孩子和右边的左孩子值相等
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left!=null && right!=null)
            return left.val==right.val && checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
        else
            return false;
    }
}
