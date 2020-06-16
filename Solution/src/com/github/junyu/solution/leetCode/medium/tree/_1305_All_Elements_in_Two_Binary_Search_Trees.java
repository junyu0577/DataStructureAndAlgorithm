package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _1305_All_Elements_in_Two_Binary_Search_Trees {

    /*Given two binary search trees root1 and root2.

    Return a list containing all the integers from both trees sorted
    in ascending order.

    Example 1:


    Input: root1 = [2,1,4], root2 = [1,0,3]
    Output: [0,1,1,2,3,4]
    Example 2:

    Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
    Output: [-10,0,0,1,2,5,7,10]
    Example 3:

    Input: root1 = [], root2 = [5,1,7,0,2]
    Output: [0,1,2,5,7]
    Example 4:

    Input: root1 = [0,-10,10], root2 = []
    Output: [-10,0,10]
    Example 5:


    Input: root1 = [1,null,8], root2 = [8,1]
    Output: [1,1,8,8]


    Constraints:

    Each tree has at most 5000 nodes.
    Each node's value is between [-10^5, 10^5].*/

    /**
     * 将两个二叉搜索树的元素放在一个集合中，升序排列。
     * 思路：既然是bst那么根据中序遍历可以得到升序的集合（这里用链表），然后同时比较两个链表的头部，
     * 将较小的poll到结果数组，直到有一个链表为空，再从另一个链表中poll剩余的元素。
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        inOrder(root1, left);
        inOrder(root2, right);
        List<Integer> ans = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek() > right.peek()) {
                ans.add(right.poll());
            } else {
                ans.add(left.poll());
            }
        }
        while (!left.isEmpty()) {
            ans.add(left.poll());
        }
        while (!right.isEmpty()) {
            ans.add(right.poll());
        }
        return ans;
    }

    private void inOrder(TreeNode root, LinkedList<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        _1305_All_Elements_in_Two_Binary_Search_Trees test = new _1305_All_Elements_in_Two_Binary_Search_Trees();
        System.out.println(test.getAllElements(TreeMaker.array2BinaryTree(new Integer[]{2, 1, 4}), TreeMaker.array2BinaryTree(new Integer[]{1, 0, 3})));
    }
}
