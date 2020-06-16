package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

    /*Return the root node of a binary search tree that matches the given
     preorder traversal.

    (Recall that a binary search tree is a binary tree where for every
     node, any descendant of node.left has a value < node.val, and any
     descendant of node.right has a value > node.val.  Also recall that
     a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

    It's guaranteed that for the given test cases there is always possible
    to find a binary search tree with the given requirements.

    Example 1:

    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]



    Constraints:

            1 <= preorder.length <= 100
            1 <= preorder[i] <= 10^8
    The values of preorder are distinct.*/

    /**
     * 先序遍历构造二叉搜索树
     * 思路：遍历数组，同时递归root，将大于当前节点的值插入到右侧，小于节点的值插入到左侧，
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            addNode(root, preorder[i]);
        }
        return root;
    }

    private TreeNode addNode(TreeNode root, int val) {
        if (root==null)
            return null;

        if (val > root.val) {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                root.right = addNode(root.right, val);
        } else if (val < root.val) {
            if (root.left==null)
                root.left = new TreeNode(val);
            else
                root.left = addNode(root.left,val);
        }
        return root;
    }

    public static void main(String[] args) {
        _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal test = new _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal();
        System.out.println(test.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }
}
