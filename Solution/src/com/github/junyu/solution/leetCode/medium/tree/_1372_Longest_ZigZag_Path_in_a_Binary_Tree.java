package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _1372_Longest_ZigZag_Path_in_a_Binary_Tree {


    /*Given a binary tree root, a ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right then move to the right child of the current node otherwise move to the left child.
    Change the direction from right to left or right to left.
    Repeat the second and third step until you can't move in the tree.
    Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

    Return the longest ZigZag path contained in that tree.

    Example 1:

    Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
    Output: 3
    Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
    Example 2:

    Input: root = [1,1,1,null,1,null,null,1,1,null,1]
    Output: 4
    Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
    Example 3:

    Input: root = [1]
    Output: 0

    Constraints:

    Each tree has at most 50000 nodes..
    Each node's value is between [1, 100].*/

    private int maxCount = 0;

    /**
     * 求二叉树的最长交错路径长度
     * 遍历二叉树时，通过isLeft字段判断他的父节点的位置，当父节点处于左边，那么前往右侧叶子节点时，就需要将当前的count进行递增。
     * 前往左侧叶子节点时，由于方向是一致，这时count就需要重新从1开始统计。父节点处于右边同理。
     * 最后每次访问到末端的叶子节点时，进行max值的更新。
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {

       dfs(root.left,1,true);
       dfs(root.right,1,false);

       return maxCount;
    }

    private void dfs(TreeNode node, int count, boolean isLeft) {
        if (node==null)
            return;

        if (isLeft){
            dfs(node.left,1,true);
            dfs(node.right,count+1,false);
        }else {
            dfs(node.left,count+1,true);
            dfs(node.right,1,false);
        }
        maxCount = Math.max(maxCount,count);
    }


    public static void main(String[] args) {
        _1372_Longest_ZigZag_Path_in_a_Binary_Tree test = new _1372_Longest_ZigZag_Path_in_a_Binary_Tree();

//        System.out.println(test.longestZigZag(TreeMaker.array2BinaryTree(new Integer[]{1,null,1,1,1,null,null,1,1,
//        null,1,null,null,null,1,null,1})));
        System.out.println(test.longestZigZag(TreeMaker.array2BinaryTree(new Integer[]{1,1,1,null,1,null,null,1,1,
        null,1})));
//        System.out.println(test.longestZigZag(TreeMaker.array2BinaryTree(new Integer[]{1})));
//        System.out.println(test.longestZigZag(TreeMaker.array2BinaryTree(new Integer[]{1,2})));
//        System.out.println(test.longestZigZag(TreeMaker.array2BinaryTree(new Integer[]{1,1,null,null,1})));
    }
}
