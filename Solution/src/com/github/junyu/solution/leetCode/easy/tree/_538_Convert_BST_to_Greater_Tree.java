package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _538_Convert_BST_to_Greater_Tree {

   /* Given a Binary Search Tree (BST), convert it to a Greater Tree such that
    every key of the original BST is changed to the original key plus sum of all
    keys greater than the original key in BST.

    Example:

    Input: The root of a Binary Search Tree like this:
            5
            /   \
            2     13

    Output: The root of a Greater Tree like this:
            18
            /   \
            20     13*/

    private int sum;

    /**
     * 这题的意思就是bst中，值最大的节点n的值不变，n-1就等于（n+n-1）,n-2等于(n+n-1+n-2)，不断累增求和，
     * 到最后原先值最小的节点变为最大的节点.
     *
     * 使用中序遍历，因为是bst，所以最大值是在右子树，求sum又是从最大值开始，那就先遍历右边的子树。
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        root = inOrder(root);
        return root;
    }

    private TreeNode inOrder(TreeNode node) {
        if (node == null)
            return null;

        inOrder(node.right);

        node.val = node.val + sum;
        sum = node.val;

        inOrder(node.left);

        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        _538_Convert_BST_to_Greater_Tree convert_bst_to_greater_tree = new _538_Convert_BST_to_Greater_Tree();
        convert_bst_to_greater_tree.convertBST(treeNode);

    }

}
