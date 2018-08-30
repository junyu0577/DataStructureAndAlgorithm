package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ShaoJunyu
 * @since 2018/8/3 09:38
 */
public class _094_Binary_Tree_Inorder_Traversal {

   /* Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
            1
            \
            2
            /
            3

    Output: [1,3,2]
    Follow up: Recursive solution is trivial, could you do it iteratively?
    */


//    /**
//     * 中序遍历 返回以节点值组成的数组
//     *
//     * @param root
//     * @return
//     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null)
//            return list;
//
//        inorder(root, list);
//        return list;
//    }
//
//    private void inorder(TreeNode node, List<Integer> list) {
//        if (node == null)
//            return;
//
//        inorder(node.left,list);
//        list.add(node.val);
//        inorder(node.right,list);
//    }

    /**
     * 用递归的方式实现
     * 使用stack，并定义一个节点指向左孩子。最外层的循环结束条件是next为空以及栈中无元素的时候。
     * 在循环中，先判断next节点是否为空，不为空就压入栈，然后指向next的左孩子，目的就是最终让next指向它的子树最底层的最左孩子。
     * 然后pop出一个元素，打印它，并将next指向它的右孩子，如果它没有右孩子，那么第二层循环就无法进入，再pop的时候就是他的parent。
     * 如果有孩子，那么就去寻找他子树的最左孩子。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode next = root.left;
        while (next != null || !stack.isEmpty()) {

            while (next != null) {
                stack.push(next);
                next = next.left;
            }

            TreeNode temp = stack.pop();
            res.add(temp.val);

            next = temp.right;

        }

        return res;
    }

    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        _094_Binary_Tree_Inorder_Traversal binary_tree_inorder_traversal = new _094_Binary_Tree_Inorder_Traversal();
        System.out.println((binary_tree_inorder_traversal.inorderTraversal(treeNode)));
    }


}
