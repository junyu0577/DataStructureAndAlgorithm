package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.*;

public class _1382_Balance_a_Binary_Search_Tree {

  /*  Given a binary search tree, return a balanced binary search tree with the same node values.

    A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more
    than 1.

    If there is more than one answer, return any of them.

    Example 1:

    Input: root = [1,null,2,null,3,null,4,null,null]
    Output: [2,1,3,null,null,null,4]
    Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.


            Constraints:

    The number of nodes in the tree is between 1 and 10^4.
    The tree nodes will have distinct values between 1 and 10^5.*/

    /**
     * 二叉搜索树平衡化
     * 解题思路：先利用中序遍历获取有序的values列表。然后通过折半的方式将左边较小的部分插入树左边的叶子节点，较大的右边部分插入
     * 树右边的叶子节点。如果不使用折半进行插入，那么会使树左右子节点都形成都链表结构。
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrder(values, root);

        return createTree(values, 0, values.size() - 1);
    }

    private TreeNode createTree(List<Integer> values, int start, int end) {
        if (start > end)
            return null;

        int mid = start+(end-start)/2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = createTree(values,start,mid-1);
        node.right = createTree(values,mid+1,end);

        return node;
    }

    private void inOrder(List<Integer> values, TreeNode node) {
        if (node == null)
            return;

        inOrder(values, node.left);
        values.add(node.val);
        inOrder(values, node.right);
    }


    public static void main(String[] args) {
        _1382_Balance_a_Binary_Search_Tree test = new _1382_Balance_a_Binary_Search_Tree();

        TreeNode rootNode = new TreeNode(1);
        TreeNode childOneRight = new TreeNode(2);
        rootNode.right = childOneRight;
        TreeNode childTwoRight = new TreeNode(3);
        childOneRight.right = childTwoRight;
        TreeNode childThreeRight = new TreeNode(4);
        childTwoRight.right = childThreeRight;

        System.out.println(test.balanceBST(rootNode));
    }

}
