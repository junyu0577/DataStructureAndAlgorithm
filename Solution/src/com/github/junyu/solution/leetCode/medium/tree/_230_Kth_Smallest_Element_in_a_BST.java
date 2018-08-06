package com.github.junyu.solution.leetCode.medium.tree;


import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

/**
 * @author ShaoJunyu
 * @since 2018/8/3 16:35
 */
public class _230_Kth_Smallest_Element_in_a_BST {
/*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
            3
            / \
            1   4
            \
            2
    Output: 1
    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
            5
            / \
            3   6
            / \
            2   4
            /
            1
    Output: 3
    */


    private int count = 0;

    /**
     * 根据题意，既然是bst，那么根据bst的特性，用中序对元素遍历后，存到数组，得到一个有序的从小到大的数组，第k-1位置的元素就是第k小的.
     * 进一步优化，因为并不需要开辟n个空间给数组，定义一个count，每次在中序位置进行count的累加，当count等于k值就意味着找到了元素
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        if (root == null)
            return -1;

        int res = 0;

        return inOrder(root, k, res);
    }

    private int inOrder(TreeNode node, int k, int res) {

        if (node == null)
            return res;

        res = inOrder(node.left, k, res);
        count++;
        if (count == k) {
            res = node.val;
            return res;
        }
        res = inOrder(node.right, k, res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);

        node.left = node2;
        node.right = node3;

        _230_Kth_Smallest_Element_in_a_BST kth_smallest_element_in_a_bst = new _230_Kth_Smallest_Element_in_a_BST();
        System.out.println(kth_smallest_element_in_a_bst.kthSmallest(node, 1));
        System.out.println(kth_smallest_element_in_a_bst.count);
    }

}
