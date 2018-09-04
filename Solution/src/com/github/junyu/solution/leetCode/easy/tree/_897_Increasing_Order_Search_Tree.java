package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;


public class _897_Increasing_Order_Search_Tree {

    /*Given a tree, rearrange the tree in in-order so that the leftmost node
    in the tree is now the root of the tree, and every node has no left child and only 1 right child.

    Example 1:
    Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

            5
            / \
            3    6
            / \    \
            2   4    8
            /        / \
            1        7   9

    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

            1
            \
            2
            \
            3
            \
            4
            \
            5
            \
            6
            \
            7
            \
            8
            \
            9
    Note:

    The number of nodes in the given tree will be between 1 and 100.
    Each node will have a unique integer value from 0 to 1000.*/

    private TreeNode res;
    private TreeNode last;

    /**
     * 将二分搜索树变成递增顺序查找树
     * bst使用中序遍历就可以获得有一个有序的集合，然后定义两个treeNode遍历，res就是最终要返回的结果，当他为空的时候，
     * 说明是根节点，last变量指向树的最右子树，每次创建并设置完右孩子，last都要指向last.next
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {

        if (root == null)
            return;

        inOrder(root.left);
        if (res == null) {
            res = new TreeNode(root.val);
            last = res;
        } else {
            last.right = new TreeNode(root.val);
            last = last.right;
        }
        inOrder(root.right);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node.left = node2;
        node.right = node3;
        _897_Increasing_Order_Search_Tree increasing_order_search_tree = new _897_Increasing_Order_Search_Tree();
        TreeNode res = increasing_order_search_tree.increasingBST(node);
        System.out.println(res);


    }

}
