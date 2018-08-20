package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _429_N_ary_Tree_Level_Order_Traversal {

   /* Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example, given a 3-ary tree:

    We should return its level order traversal:

    Note:

    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.

    */

    /**
     * N叉树的层序遍历，每一层组成一个list加入到list中
     * 思路仍然和二叉树的层序遍历一致，建立一个队列，每一次遍历队列都是处理当前层的元素
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node cur = q.removeFirst();
                list.add(cur.val);

                if (cur.children != null) {//在leetcode的测试用例中，child都不为空，将这个判断逻辑去掉可以提升一点点效率
                    q.addAll(cur.children);
                }
            }
            res.add(list);
        }

        return res;

    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node());
        nodes.add(new Node());
        nodes.add(new Node());
        nodes.get(0).val = 2;
        nodes.get(1).val = 3;
        nodes.get(2).val = 4;
        Node node = new Node(1, nodes);
        _429_N_ary_Tree_Level_Order_Traversal n_ary_tree_level_order_traversal = new _429_N_ary_Tree_Level_Order_Traversal();
        List<List<Integer>> res = n_ary_tree_level_order_traversal.levelOrder(node);
        for (List<Integer> list : res) {
            System.out.println((list));
        }

    }
}
