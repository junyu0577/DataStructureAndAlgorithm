package com.github.junyu.solution.data_structure.utils;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class TreeMaker {

    /**
     * 将数组转化为二叉树
     *
     * @param arr
     * @return
     */
    public static TreeNode array2BinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        TreeNode treeNode = new TreeNode(arr[0]);
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(treeNode);
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] ==null && arr[i+1] == null)
                continue;

            TreeNode node = linkedList.removeFirst();
            if (arr[i] != null) {
                TreeNode leftChildNode = new TreeNode(arr[i]);
                node.left = leftChildNode;
                linkedList.add(leftChildNode);
            }
            if (i + 1 < arr.length && arr[i + 1] != null) {
                TreeNode rightChildNode = new TreeNode(arr[i + 1]);
                node.right = rightChildNode;
                linkedList.add(rightChildNode);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeMaker.array2BinaryTree(new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null,
                null, null, 1, null, 1});
        System.out.println(treeNode);
    }

}
