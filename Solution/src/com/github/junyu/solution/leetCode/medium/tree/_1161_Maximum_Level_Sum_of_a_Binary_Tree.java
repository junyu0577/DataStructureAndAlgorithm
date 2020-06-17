package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree {

    /*Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

    Return the smallest level X such that the sum of all the values of nodes at level X is maximal.



    Example 1:



    Input: [1,7,0,7,-8,null,null]
    Output: 2
    Explanation:
    Level 1 sum = 1.
    Level 2 sum = 7 + 0 = 7.
    Level 3 sum = 7 + -8 = -1.
    So we return the level with the maximum sum which is level 2.


    Note:

    The number of nodes in the given tree is between 1 and 10^4.
            -10^5 <= node.val <= 10^5*/

    /**
     * 最大层内元素和
     * 思路：使用层序遍历，统计当前层的元素和，和上一次记录的maxSum做比较，大于则更新层数。
     * 统计完一层后需要移除当前层的所有元素并添加下一层的元素。
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int level = 0;
        int ans = 0;
        int maxSum = 0;
        while (!list.isEmpty()) {
            int sum = 0;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.poll();
                sum += treeNode.val;
                if (treeNode.left != null)
                    list.add(treeNode.left);
                if (treeNode.right != null)
                    list.add(treeNode.right);
            }

            level++;
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1161_Maximum_Level_Sum_of_a_Binary_Tree test = new _1161_Maximum_Level_Sum_of_a_Binary_Tree();
        System.out.println(test.maxLevelSum(TreeMaker.array2BinaryTree(new Integer[]{1, 7, 0, 7, -8, null, null})));
    }
}
