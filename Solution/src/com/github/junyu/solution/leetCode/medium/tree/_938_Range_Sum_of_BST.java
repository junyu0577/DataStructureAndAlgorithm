package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _938_Range_Sum_of_BST {

   /* Given the root node of a binary search tree, return the sum of values
    of all nodes with value between L and R (inclusive).

    The binary search tree is guaranteed to have unique values.



    Example 1:

    Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
    Output: 32
    Example 2:

    Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
    Output: 23


    Note:

    The number of nodes in the tree is at most 10000.
    The final answer is guaranteed to be less than 2^31.*/

    private int sum;

    /**
     * 累加L和R之间的所有节点的值
     * 深度优先递归bst，如果当前的节点在L和R之间，那么累加上sum。
     * 然后继续判断是否进行向下递归，如果当前的节点的值大于L，就继续向左子节点递归。
     * 同理，如果当前的节点小于R，就继续向右子节点递归。
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        sum = 0;
        dfs(root, L, R);
        return sum;
    }

    private void dfs(TreeNode root, int l, int r) {
        if (root != null) {
            if (l <= root.val && r >= root.val) {
                sum += root.val;
            }

            if (l<root.val)
                dfs(root.left,l,r);

            if (r>root.val)
                dfs(root.right,l,r);

        }
    }


        public static void main (String[]args){
            TreeNode treeNode = new TreeNode(10);
            TreeNode treeNode2 = new TreeNode(5);
            TreeNode treeNode3 = new TreeNode(15);
            TreeNode treeNode4 = new TreeNode(3);
            TreeNode treeNode5 = new TreeNode(7);
            TreeNode treeNode6 = new TreeNode(18);

            treeNode.left = treeNode2;
            treeNode.right = treeNode3;

            treeNode2.left = treeNode4;
            treeNode2.right = treeNode5;

            treeNode3.right = treeNode6;

            _938_Range_Sum_of_BST range_sum_of_bst = new _938_Range_Sum_of_BST();

            System.out.println(range_sum_of_bst.rangeSumBST(treeNode, 7, 15));

        }
    }
