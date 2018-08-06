package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _107_Binary_Tree_Level_Order_Traversal_II {

/*

    Given a binary tree, return the bottom-up level order traversal of
    its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
            / \
            9  20
            /  \
            15   7
            return its bottom-up level order traversal as:
            [
            [15,7],
            [9,20],
            [3]
            ]
*/


    /**
     * 层序遍历，从底层开始,
     * 只要在插入每一层元素的时候，插在res集合的第0个位置就好了
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            int length = q.size();
            List<Integer> levels = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode temp = q.removeFirst();
                levels.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
            if (length > 0)
                res.add(0, levels);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        tree.left = tree2;
        tree.right = tree3;
        _107_Binary_Tree_Level_Order_Traversal_II binary_tree_level_order_traversal_ii = new _107_Binary_Tree_Level_Order_Traversal_II();
        List<List<Integer>> res = binary_tree_level_order_traversal_ii.levelOrderBottom(tree);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }
    }

}
