package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class _993_Cousins_in_Binary_Tree {

    /*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

    Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

    We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the
    tree.

    Return true if and only if the nodes corresponding to the values x and y are cousins.

    Example 1:

    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false
    Example 2:


    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true
    Example 3:



    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false


    Constraints:

    The number of nodes in the tree will be between 2 and 100.
    Each node has a unique integer value from 1 to 100.*/

    /**
     * 二叉树的堂兄弟节点
     * 思路：通过层序遍历，去判断当前层的所有子节点是否有包含x和y，只要是x和y不是同一个父节点就行。
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int len = list.size();
            int cousinIndex = -1;
            for (int i = 0; i < len; i++) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    if ((node.left.val == x || node.left.val == y)) {
                        if (cousinIndex!=-1 && i!=cousinIndex)
                            return true;
                        cousinIndex = i;
                    }
                    list.add(node.left);
                }

                if (node.right != null) {
                    if (node.right.val == x || node.right.val == y) {
                        if (cousinIndex!=-1 && i!=cousinIndex)
                            return true;
                        cousinIndex = i;
                    }
                    list.add(node.right);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _993_Cousins_in_Binary_Tree test = new _993_Cousins_in_Binary_Tree();
        System.out.println(test.isCousins(TreeMaker.array2BinaryTree(new Integer[]{1, 2, 3, 4}), 4, 3));
        System.out.println(test.isCousins(TreeMaker.array2BinaryTree(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4));
        System.out.println(test.isCousins(TreeMaker.array2BinaryTree(new Integer[]{1, 2, 3, null, 4}), 2, 3));
    }
}
