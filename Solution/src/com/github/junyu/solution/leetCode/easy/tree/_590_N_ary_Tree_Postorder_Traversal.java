package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.Node;

import java.util.ArrayList;
import java.util.List;

public class _590_N_ary_Tree_Postorder_Traversal {

   /* Given an n-ary tree, return the postorder traversal of its nodes' values.

    For example, given a 3-ary tree:

    Return its postorder traversal as: [5,6,3,2,4,1].


    Note: Recursive solution is trivial, could you do it iteratively?*/


    /**
     * N叉树的后序遍历
     * 和二叉树类似，区别在于对于子节点是一个list
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        postOrder(root, res);

        return res;
    }

    private void postOrder(Node root, List<Integer> res) {
        if (root == null)
            return;

        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                postOrder(root.children.get(i), res);
            }
        }

        res.add(root.val);
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
        _590_N_ary_Tree_Postorder_Traversal n_ary_tree_postorder_traversal = new _590_N_ary_Tree_Postorder_Traversal();
        System.out.println(n_ary_tree_postorder_traversal.postorder(node));
    }
}
