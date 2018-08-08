package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _700_Search_in_a_Binary_Search_Tree {


  /*  Given the root node of a binary search tree (BST) and a value. You need to find
    the node in the BST that the node's value equals the given value. Return the subtree
    rooted with that node. If such node doesn't exist, you should return NULL.

            For example,

    Given the tree:
            4
            / \
            2   7
            / \
            1   3

    And the value to search: 2
    You should return this subtree:

            2
            / \
            1   3
    In the example above, if we want to search the value 5, since there is no
    node with value 5, we should return NULL.

    Note that an empty tree is represented by NULL, therefore you would see the
    expected output (serialized tree format) as [], not null*/

    /**
     * 二叉搜索树的查找
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;
        else if (val > root.val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(7);
        TreeNode tree4 = new TreeNode(1);
        TreeNode tree5 = new TreeNode(3);

        tree.left = tree2;
        tree.right = tree3;
        tree2.left = tree4;
        tree2.right = tree5;

        _700_Search_in_a_Binary_Search_Tree search_in_a_binary_search_tree = new _700_Search_in_a_Binary_Search_Tree();
        TreeNode treeNode = search_in_a_binary_search_tree.searchBST(tree, 2);
        System.out.println(treeNode);
    }

}
