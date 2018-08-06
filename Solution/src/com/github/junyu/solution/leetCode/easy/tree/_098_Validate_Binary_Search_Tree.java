package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author ShaoJunyu
 * @since 2018/7/25 09:51
 */
public class _098_Validate_Binary_Search_Tree {

    /*Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:

    Input:
            2
            / \
            1   3
    Output: true
    Example 2:

            5
            / \
            1   4
            / \
            3   6
    Output: false
    Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
    is 5 but its right child's value is 4.*/



    public static boolean isValidBST(TreeNode root) {

        return searchBst(root, null, null);
    }

    /**
     * 利用递归遍历，只要当前的节点比左边的小，或者比右边的大，就不满足bst的条件
     *
     * @param root
     * @param left
     * @param right
     * @return
     */
    private static boolean searchBst(TreeNode root, Integer left, Integer right) {
        if (root == null)
            return true;

        if (left != null && root.val <= left || right != null && root.val >= right)
            return false;

        return searchBst(root.left, left, root.val) && searchBst(root.right, root.val, right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(20);
        System.out.println(isValidBST(treeNode));
    }

//    public static boolean isValidBST(TreeNode root) {
//        List<Integer> v = new ArrayList<>();
//        searchBst(root, v);
//        for (int i = 0; i < v.size() - 1; i++) {
//            if (v.get(i) >= v.get(i + 1))
//                return false;
//        }
//        return true;
//    }
//
//    /**
//     * 利用中序遍历 将遍历到的元素存入到list中，最后遍历list比较相邻元素的大小得出结果
//     *
//     * @param node
//     * @return
//     */
//    public static void searchBst(TreeNode node,  List<Integer> v) {
//        if (node == null)
//            return;
//        searchBst(node.left, v);
//        v.add(node.val);
//        searchBst(node.right, v);
//    }
}
