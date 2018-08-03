package com.github.junyu.solution.leetCode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaoJunyu
 * @since 2018/8/3 09:38
 */
public class _094_Binary_Tree_Inorder_Traversal {

   /* Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
            1
            \
            2
            /
            3

    Output: [1,3,2]
    Follow up: Recursive solution is trivial, could you do it iteratively?
    */


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 中序遍历 返回以节点值组成的数组
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        treeNode.right = treeNode12;
        treeNode12.left = new TreeNode(3);

        _094_Binary_Tree_Inorder_Traversal binary_tree_inorder_traversal = new _094_Binary_Tree_Inorder_Traversal();
        System.out.println((binary_tree_inorder_traversal.inorderTraversal(treeNode)));
    }


}
