package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;


public class _1022_Sum_of_Root_To_Leaf_Binary_Numbers {

    /*
    Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents
    a binary number starting with the most significant bit.  For example,
    if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

    Return the sum of these numbers.



    Example 1:



    Input: [1,0,1,0,1,0,1]
    Output: 22
    Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


    Note:

    The number of nodes in the tree is between 1 and 1000.
    node.val is 0 or 1.
    The answer will not exceed 2^31 - 1.
    */

    /**
     * 计算二叉数从root到leaf的各条path上的元素所组成的元（二进制转十进制）的和
     * 通过前序遍历，每次获得一个当前元素，就进行一次求和操作，通过左移一位然后与上当前元素，就得到当前二进制转换十进制
     * 后的只，然后累加到val，只有当遇到叶子节点时，回到这个val。
     * 这种通过左移然后与的运算获得十进制值的方法同样在题目《1018》使用过。
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        return countPathsValue(root, 0);
    }

    private int countPathsValue(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        val = val << 1 | root.val;

        if (root.left == null && root.right == null)
            return val;

        return countPathsValue(root.left, val) + countPathsValue(root.right, val);

    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(1);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(new _1022_Sum_of_Root_To_Leaf_Binary_Numbers().sumRootToLeaf(treeNode));

    }
}
