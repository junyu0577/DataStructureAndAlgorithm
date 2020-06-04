package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _1302_Deepest_Leaves_Sum {

    /*Given a binary tree, return the sum of values of its deepest leaves.

    Example 1:

    Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
    Output: 15


    Constraints:

    The number of nodes in the tree is between 1 and 10^4.
    The value of nodes is between 1 and 100.*/

    private int maxDeep;
    private int sum = 0;

    /**
     * 最深叶子节点的总和
     * 思路：前序遍历判断当前是否是叶子节点，如果是叶子节点就接着判断当前的层级，
     * 如果当前层级与最大记录层级相同则sum累加。
     * 如果当前层级大于记录的最大层级则更新开始累加sum。
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }

    private void preOrder(TreeNode root, int level) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (level > maxDeep) {
                maxDeep = level;
                sum = root.val;
            } else if (level == maxDeep) {
                sum += root.val;
            }
        }

        preOrder(root.left, level + 1);
        preOrder(root.right, level + 1);
    }

    public static void main(String[] args) {
        _1302_Deepest_Leaves_Sum test = new _1302_Deepest_Leaves_Sum();
        System.out.println(test.deepestLeavesSum(TreeMaker.array2BinaryTree(
                new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8})));
    }
}
