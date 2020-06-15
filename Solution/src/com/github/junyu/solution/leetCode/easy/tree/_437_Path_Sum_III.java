package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _437_Path_Sum_III {

    /*You are given a binary tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must
    go downwards (traveling only from parent nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the
    range -1,000,000 to 1,000,000.

    Example:

    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

             10
            /  \
           5   -3
          / \    \
         3   2   11
        / \   \
       3  -2   1

    Return 3. The paths that sum to 8 are:

            1.  5 -> 3
            2.  5 -> 2 -> 1
            3. -3 -> 11
*/
    public void resetAns() {
        ans = 0;
    }

    private int ans = 0;

    /**
     * 和为sum的路径数量
     * 思路：穷举，从一个点出发，探索从这个点到叶子节点是否有和为sum的路径，这里使用反向即sum-当前节点的值，
     * 如果子节点的值与传进来的差值相等，那么数量+1。
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        preOrder(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    private void preOrder(TreeNode root, int sum) {
        if (root == null)
            return;

        if (sum == root.val)
            ans++;

        preOrder(root.left, sum - root.val);
        preOrder(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        _437_Path_Sum_III test = new _437_Path_Sum_III();
        System.out.println(test.pathSum(TreeMaker.array2BinaryTree(new Integer[]{
                10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
        }), 8));
        test.resetAns();
        System.out.println(test.pathSum(TreeMaker.array2BinaryTree(new Integer[]{
                1}), 1));
    }
}
