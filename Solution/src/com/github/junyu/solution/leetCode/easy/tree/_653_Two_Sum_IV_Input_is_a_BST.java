package com.github.junyu.solution.leetCode.easy.tree;


import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _653_Two_Sum_IV_Input_is_a_BST {

/*
    Given a Binary Search Tree and a target number, return true if there exist two
    elements in the BST such that their sum is equal to the given target.

            Example 1:
    Input:
            5
            / \
            3   6
            / \   \
            2   4   7

    Target = 9

    Output: True
    Example 2:
    Input:
            5
            / \
            3   6
            / \   \
            2   4   7

    Target = 28

    Output: False*/


//    private boolean res;
//
//    /**
//     * 这题目和两数类似，只不过这个是在bst上
//     * 使用前序遍历去求解,将k-node.value的值存入hashset中，
//     * 每次遍历到一个新元素就查看一下是否已经在集合中存在，存在即满足条件
//     *
//     * @param root
//     * @param k
//     * @return
//     */
//    public boolean findTarget(TreeNode root, int k) {
//        findResult(root, k, new HashSet<Integer>());
//        return res;
//    }
//
//    private void findResult(TreeNode node, int k, HashSet set) {
//
//        if (node == null)
//            return;
//
//        if (set.contains(node.val)) {
//            res = true;
//            return;
//        }
//
//        set.add(k - node.val);
//
//        findResult(node.left, k, set);
//        findResult(node.right, k, set);
//
//    }


    /**
     * 另一种解法是在中序遍历时，将元素都存到list中，最后遍历list插入是否存在两数之和为target
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        findResult(root, k, list);
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == k)
                return true;
            else if (sum > k) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }

    private void findResult(TreeNode node, int k, List list) {

        if (node == null)
            return;

        findResult(node.left, k, list);
        list.add(node.val);
        findResult(node.right, k, list);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        _653_Two_Sum_IV_Input_is_a_BST two_sum_iv_input_is_a_bst = new _653_Two_Sum_IV_Input_is_a_BST();
        System.out.println(two_sum_iv_input_is_a_bst.findTarget(treeNode, 4));
    }

}
