package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _257_Binary_Tree_Paths {


/*

    Given a binary tree, return all root-to-leaf paths.

    Note: A leaf is a node with no children.

    Example:

    Input:

            1
            /   \
            2     3
            \
            5

    Output: ["1->2->5", "1->3"]

    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/

    /**
     * 得到从root到leaf的所有路径
     *
     * 采用dfs 后序遍历,在遍历到叶子节点时将拼接的字符串添加进集合
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null)
            return res;


        postOrder(res, "", root);

        return res;
    }

    private void postOrder(List<String> res, String s, TreeNode node) {
        if (node == null) {
            return;
        }

        if ("".equals(s))
            s = s + node.val;
        else
            s = s + "->" + node.val;

        postOrder(res, s, node.left);

        postOrder(res, s, node.right);

        if (node.left == null && node.right == null)
            res.add(s);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;

        _257_Binary_Tree_Paths Binary_Tree_Paths = new _257_Binary_Tree_Paths();
        System.out.println(Binary_Tree_Paths.binaryTreePaths(treeNode));
    }

}
