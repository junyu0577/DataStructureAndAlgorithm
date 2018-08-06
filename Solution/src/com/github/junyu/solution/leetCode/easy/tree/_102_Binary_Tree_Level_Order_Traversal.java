package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/24 19:45
 */
public class _102_Binary_Tree_Level_Order_Traversal {

  /*  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],*/

         /* 3
           / \
          9  20
             /  \
            15    7*/

   /* return its level order traversal as:*/

       /* [
        [3],
        [9,20],
        [15,7]
        ]*/


    /**
     * 二叉树的层序遍历 BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode node = root;
        Queue<TreeNode> list = new LinkedList();
        list.add(node);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        innerList.add(root.val);
        result.add(innerList);
        while (list.size() > 0) {

            innerList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = list.remove();
                if (tempNode.left != null) {
                    list.add(tempNode.left);
                    innerList.add(tempNode.left.val);
                }

                if (tempNode.right != null) {
                    list.add(tempNode.right);
                    innerList.add(tempNode.right.val);

                }
            }

            if (innerList.size() > 0)
                result.add(innerList);
        }
        return result;
    }
}
