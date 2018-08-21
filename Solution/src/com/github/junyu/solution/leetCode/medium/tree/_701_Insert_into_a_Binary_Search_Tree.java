package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _701_Insert_into_a_Binary_Search_Tree {

  /*  Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST.
   Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

    Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

            For example,

    Given the tree:
            4
            / \
            2   7
            / \
            1   3
    And the value to insert: 5
    You can return this binary search tree:

            4
            /   \
            2     7
            / \   /
            1   3 5
    This tree is also valid:

            5
            /   \
            2     7
            / \
            1   3
            \
            4*/

    /**
     * 在bst中插入新元素，返回root节点，不会插入重复元素
     * bst的特征就是左小右大，如果不会是重复的元素,只需要判断着两个条件就可以
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val < val)//right
            root.right = insertIntoBST(root.right, val);
        else if (root.val > val)//left
            root.left = insertIntoBST(root.left, val);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        _701_Insert_into_a_Binary_Search_Tree insert_into_a_binary_search_tree = new _701_Insert_into_a_Binary_Search_Tree();
        TreeNode node = insert_into_a_binary_search_tree.insertIntoBST(treeNode,4);
        TreeNode node1 = insert_into_a_binary_search_tree.insertIntoBST(treeNode,0);
        System.out.println(node1);
    }

}
