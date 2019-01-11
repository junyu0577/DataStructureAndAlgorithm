package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;


public class _951_Flip_Equivalent_Binary_Trees {

   /* For a binary tree T, we can define a flip operation as follows:
    choose any node, and swap the left and right child subtrees.

    A binary tree X is flip equivalent to a binary tree Y if and
    only if we can make X equal to Y after some number of flip operations.

    Write a function that determines whether two binary trees are flip equivalent.
    The trees are given by root nodes root1 and root2.



    Example 1:

    Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 =
            [1,3,2,null,6,4,5,null,null,null,null,8,7]
    Output: true
    Explanation: We flipped at nodes with values 1, 3, and 5.
    Flipped Trees Diagram


    Note:

    Each tree will have at most 100 nodes.
    Each value in each tree will be a unique integer in the range [0, 99].*/

    /**
     * 判断两棵树的部分子树交换位置后相等
     * 递归两颗树，分别进行左左和右右以及左右和右左子树的比较。
     * 在这过程中只要满足有一边满足则最后条件即成立。
     * 将终止条件设置为两个节点都为空。
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;


        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }

    public static void main(String[] args) {
        _951_Flip_Equivalent_Binary_Trees flip_equivalent_binary_trees = new _951_Flip_Equivalent_Binary_Trees();

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(3);

        treeNode11.right = treeNode22;
        treeNode11.left = treeNode33;

        System.out.println(flip_equivalent_binary_trees.flipEquiv(treeNode, treeNode11));
    }

}
