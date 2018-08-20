package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _814_Binary_Tree_Pruning {


    /*We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

    Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

            (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

    Example 1:
    Input: [1,null,0,0,1]
    Output: [1,null,0,null,1]

    Explanation:
    Only the red nodes satisfy the property "every subtree not containing a 1".
    The diagram on the right represents the answer.


    Example 2:
    Input: [1,0,1,0,0,0,1]
    Output: [1,null,1,null,1]



    Example 3:
    Input: [1,1,0,1,1,0,1,0]
    Output: [1,1,0,1,1,null,1]



    Note:

    The binary tree will have at most 100 nodes.
    The value of each node will only be 0 or 1.*/

    /**
     * 删除二叉树中节点值为0 并且左右子树都是为空的节点
     * 使用后序遍历，因为后序遍历先遍历左右子节点，再遍历根，根据这个特性，到某一个节点时判断左右子树值都为空并且节点值为0，
     * 就满足删除的条件
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0)
            return null;

        return root;
    }


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode.left = treeNode2;
        treeNode2.left = treeNode3;

        _814_Binary_Tree_Pruning binary_tree_pruning = new _814_Binary_Tree_Pruning();
        TreeNode node = binary_tree_pruning.pruneTree(treeNode);
        System.out.println(node);
    }
}
