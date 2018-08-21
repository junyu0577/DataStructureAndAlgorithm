package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class _572_Subtree_of_Another_Tree {

  /*  Given two non-empty binary trees s and t, check whether tree t has exactly the
    same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s
    and all of this node's descendants. The tree s could also be considered as a subtree of itself.

    Example 1:
    Given tree s:

            3
            / \
            4   5
            / \
            1   2
    Given tree t:
            4
            / \
            1   2
    Return true, because t has the same structure and node values with a subtree of s.
    Example 2:
    Given tree s:

            3
            / \
            4   5
            / \
            1   2
            /
            0
    Given tree t:
            4
            / \
            1   2
    Return false.*/

//    /**
//     * 判断t是否是s的子串，前提是t与s的左右子树都相同
//     * 转换一下思路，通过使用前序遍历加s和t的元素都添加进两个StringBuild中，最后通过判断s的
//     * StringBuild是否包含t的，满足则是子树。
//     * 在添加进StringBuild的时候，需要处理左右孩子为空的情况,否则再判断包含的时候会出错。
//     * 这种方式在最后的子串查询要消耗不少性能
//     * @param s
//     * @param t
//     * @return
//     */
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        StringBuilder sbS = new StringBuilder();
//        StringBuilder sbT = new StringBuilder();
//        generateStr(sbS, s);
//        generateStr(sbT, t);
//        return sbS.toString().contains(sbT.toString());
//    }
//
//    private void generateStr(StringBuilder sbS, TreeNode s) {
//        if (s == null){
//            sbS.append(",#");
//            return;
//        }
//
//        sbS.append(","+s.val);
//
//        generateStr(sbS,s.left);
//        generateStr(sbS,s.right);
//    }


    /**
     * 递归比较方式
     * 从根节点开始、从左子树或者右子树的第一个节点开始，往下不断的进行比较，只要满足上述三种情况中的一种，就是子树
     * isSameTree的流程和100题一样
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        if (isSameTree(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(11);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;


        TreeNode treeNode11 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(1);
        TreeNode treeNode33 = new TreeNode(2);

        treeNode11.left = treeNode22;
        treeNode11.right = treeNode33;

        _572_Subtree_of_Another_Tree subtree_of_another_tree = new _572_Subtree_of_Another_Tree();
        System.out.println(subtree_of_another_tree.isSubtree(treeNode, treeNode11));

    }
}
