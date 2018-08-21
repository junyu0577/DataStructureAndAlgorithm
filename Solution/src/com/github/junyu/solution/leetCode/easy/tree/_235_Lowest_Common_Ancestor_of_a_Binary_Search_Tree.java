package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    /*Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is
    defined between two nodes p and q as the lowest node in T that has both p and q as
    descendants (where we allow a node to be a descendant of itself).”

    Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

    _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
           0      _4       7       9
            /  \
            3   5
    Example 1:

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.
    Example 2:

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
    according to the LCA definition.
            Note:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the BST.*/

    /**
     * 最近的公共祖先节点
     * 分为这五种情况情况:
     * p和q有一个就是root，那么root就是公共祖先节点
     * p和q其中一个比root大，一个比root小（两种情况）
     * 当root的val比p和q都要大，那么去左子树去找
     * 当root的val比p和q都要小，去右子树找
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val)//其中一个是root
            return root;
        if (root.val > p.val && root.val < q.val)//分别位于root的左右子树
            return root;
        if (root.val < p.val && root.val > q.val)//分别位于root的左右子树
            return root;
        if (root.val > p.val && root.val > q.val)//两个都是左子树
            return lowestCommonAncestor(root.left, p, q);
        else//两个都在右子树
            return lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(1);

        treeNode.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;

        TreeNode treeNode33 = new TreeNode(2);
        TreeNode treeNode44 = new TreeNode(1);

        _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree lowest_common_ancestor_of_a_binary_search_tree = new _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        TreeNode node = lowest_common_ancestor_of_a_binary_search_tree.lowestCommonAncestor(treeNode, treeNode33, treeNode44);
        System.out.println(node);
    }
}
