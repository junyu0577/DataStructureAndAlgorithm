package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _669_Trim_a_Binary_Search_Tree {

  /*  Given a binary search tree and the lowest and highest boundaries as L and R,
    trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change
    the root of the tree, so the result should return the new root of the trimmed binary search tree.

            Example 1:
    Input:
            1
            / \
            0   2

    L = 1
    R = 2

    Output:
            1
            \
            2
    Example 2:
    Input:
            3
            / \
            0   4
            \
            2
            /
            1

    L = 1
    R = 3

    Output:
            3
            /
            2
            /
            1*/

    /**
     * 删除bst中L-R以外的元素
     * 首先从根节点出发，判断根节点的val是否小于L，小于的话说明左子树的元素包括root都不满足条件，直接递归又子树。
     * 如果根节点的val大于R，那么根节点以及右子树都不满足条件。
     * 然后对于满足条件的子树做递归操作
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        if (root.val < L)
            return trimBST(root.right, L, R);
        if (root.val > R)
            return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        _669_Trim_a_Binary_Search_Tree trim_a_binary_search_tree = new _669_Trim_a_Binary_Search_Tree();
        TreeNode tree = trim_a_binary_search_tree.trimBST(treeNode, 0, 1);
        System.out.println(tree);
    }

}
