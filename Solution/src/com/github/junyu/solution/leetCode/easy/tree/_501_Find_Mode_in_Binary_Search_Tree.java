package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.*;

public class _501_Find_Mode_in_Binary_Search_Tree {

    /*Given a binary search tree (BST) with duplicates, find all the mode(s)
    (the most frequently occurred element) in the given BST.

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.


    For example:
    Given BST [1,null,2,2],

            1
             \
              2
            /
           2


            return [2].

    Note: If a tree has more than one mode, you can return them in any order.

    Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to
     recursion does not count).
*/

    private int max = 0;

    /**
     * 二叉搜索树中的众数
     * 思路：统计数字出现的次数，并记录出现次数最多的次数。
     * 最后迭代map找出出现次数和max相等的那些元素。
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap();
        preOrder(map, root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }

    private void preOrder(HashMap<Integer, Integer> map, TreeNode root) {
        if (root == null)
            return;
        int count =  map.getOrDefault(root.val, 0) + 1;
        max = Math.max(max,count);
        map.put(root.val,count);
        preOrder(map, root.left);
        preOrder(map, root.right);
    }

    public static void main(String[] args) {
        _501_Find_Mode_in_Binary_Search_Tree test = new _501_Find_Mode_in_Binary_Search_Tree();
        System.out.println(Arrays.toString(test.findMode(TreeMaker.array2BinaryTree(new Integer[]{1, null, 2, 2}))));
    }
}
