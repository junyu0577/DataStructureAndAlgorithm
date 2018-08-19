package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _872_Leaf_Similar_Trees {

    /*Consider all the leaves of a binary tree.  From left to right order, the values of those
    leaves form a leaf value sequence.


    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

    Two binary trees are considered leaf-similar if their leaf value sequence is the same.

            Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



            Note:

    Both of the given trees will have between 1 and 100 nodes.*/


    /**
     * 判断两棵树的所有叶子节点组成的集合顺序是否相同
     * 使用前序遍历，递归过程中只要发现是叶子节点就往集合中添加，最后比较两个list中每个元素是否相同，不同就返回
     * false
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        preOrder(root1, left);
        preOrder(root2, right);

        if (left.size() != right.size()) {
            return false;
        }

        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != right.get(i))
                return false;
        }
        return true;

    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            list.add(node.val);
        }

        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public static void main(String[] args) {

    }
}
