package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_Binary_Tree_Preorder_Traversal {

    /*Given a binary tree, return the preorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
            1
            \
            2
            /
            3

    Output: [1,2,3]
    Follow up: Recursive solution is trivial, could you do it iteratively?*/

    /**
     * 二叉树的前序遍历，要求不能使用递归
     * 使用stack去实现，有点类似层序遍历，先将root压入栈，开始进行循环，只要栈不为空，就继续。
     * 在循环体中，首先pop出一个元素，这个元素就是当前要打印的元素，然后在查看该元素是否有右孩子，有的话就push，
     * 再查看是否有左孩子。由于是先进后出的原则，右孩子永远要比左孩子后打印。最底层的右孩子要比上层的右孩子先打印。
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if (root==null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);

            if (temp.right!=null)
                stack.push(temp.right);

            if (temp.left!=null)
                stack.push(temp.left);
        }

        return res;
    }

    public static void main(String [] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        System.out.println(new _144_Binary_Tree_Preorder_Traversal().preorderTraversal(treeNode));
    }

}
