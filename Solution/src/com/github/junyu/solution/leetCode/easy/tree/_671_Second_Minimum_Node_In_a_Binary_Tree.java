package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _671_Second_Minimum_Node_In_a_Binary_Tree {

   /* Given a non-empty special binary tree consisting of nodes with the non-negative value,
    where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
    then this node's value is the smaller value among its two sub-nodes.

    Given such a binary tree, you need to output the second minimum value in the set made of all the
    nodes' value in the whole tree.

    If no such second minimum value exists, output -1 instead.

            Example 1:
    Input:
            2
            / \
            2   5
            / \
            5   7

    Output: 5
    Explanation: The smallest value is 2, the second smallest value is 5.
    Example 2:
    Input:
            2
            / \
            2   2

    Output: -1
    Explanation: The smallest value is 2, but there isn't any second smallest value.*/

    /**
     * 在bst中找出第二小的元素
     *
     * 先将元素都添加到集合，然后对集合进行一次排序，第一个元素是最小值，在遍历比较过程中，只要有值大于min了，那么就找到
     * 第二小的值了，然后都遍历完没有值比min到，那么说明里面的元素都是一样大，返回-1.
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        Collections.sort(list);
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (min < list.get(i))
                return list.get(i);

        }
        return -1;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode3.left = treeNode4;

        _671_Second_Minimum_Node_In_a_Binary_Tree second_minimum_node_in_a_binary_tree = new _671_Second_Minimum_Node_In_a_Binary_Tree();
        System.out.println(second_minimum_node_in_a_binary_tree.findSecondMinimumValue(treeNode));
    }

}
