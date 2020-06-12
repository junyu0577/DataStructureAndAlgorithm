package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _113_Path_Sum_II {

    /*Given a binary tree and a sum, find all root-to-leaf paths where each
        path's sum equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

             5
            / \
           4   8
          /   / \
         11  13  4
        /  \    / \
       7    2  5   1
    Return:

            [
            [5,4,11,2],
            [5,8,4,5]
            ]
    */

    /**
     * 找到所有从根到叶子节点总和为sum的所有路径
     * 思路：前序遍历二叉树，访问下一个子节点时，将sum减去当前的值，当到达叶子节点是，如果当前叶子节点的
     * 值和当前sum相等，就说明这条路径总和为sum。
     * 回溯到上一个节点时，注意要清除节点。
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        preOrder(root, ans, sum, new LinkedList<>());
        return ans;
    }

    private void preOrder(TreeNode root, List<List<Integer>> ans, int sum, LinkedList<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                ans.add(new ArrayList<>(list));
        } else {
            preOrder(root.left, ans, sum - root.val, list);
            preOrder(root.right, ans, sum - root.val, list);
        }
        list.pollLast();
    }


    public static void main(String[] args) {
        _113_Path_Sum_II test = new _113_Path_Sum_II();
        System.out.println(test.pathSum(
                TreeMaker.array2BinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
        System.out.println(test.pathSum(
                TreeMaker.array2BinaryTree(new Integer[]{1, -2, -3, 1, 3, -2, null, -1}), 2));
    }
}
