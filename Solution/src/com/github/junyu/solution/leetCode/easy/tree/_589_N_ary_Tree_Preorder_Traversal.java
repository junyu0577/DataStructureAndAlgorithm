package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.Node;

import java.util.ArrayList;
import java.util.List;

public class _589_N_ary_Tree_Preorder_Traversal {


/*    Given an n-ary tree, return the preorder traversal of its nodes' values.

    For example, given a 3-ary tree:

    Return its preorder traversal as: [1,3,5,6,2,4].


    Note: Recursive solution is trivial, could you do it iteratively?*/


    /**
     * N叉树的前序遍历
     * 和二叉树类似，区别在于对于子节点是一个list
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        preOrder(root, res);

        return res;
    }

    private void preOrder(Node root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);

        if (root.children != null) {
            for (Node n : root.children) {
                preOrder(n, res);
            }
        }
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
        _589_N_ary_Tree_Preorder_Traversal n_ary_tree_preorder_traversal = new _589_N_ary_Tree_Preorder_Traversal();
        System.out.println(n_ary_tree_preorder_traversal.preorder(node));
    }
}
