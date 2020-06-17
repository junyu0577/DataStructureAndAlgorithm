package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _1448_Count_Good_Nodes_in_Binary_Tree {

    /*Given a binary tree root, a node X in the tree is named good if in the path from root to X
    there are no nodes with a value greater than X.

    Return the number of good nodes in the binary tree.

    Example 1:

    Input: root = [3,1,4,3,null,1,5]
    Output: 4
    Explanation: Nodes in blue are good.
            Root Node (3) is always a good node.
    Node 4 -> (3,4) is the maximum value in the path starting from the root.
            Node 5 -> (3,4,5) is the maximum value in the path
    Node 3 -> (3,1,3) is the maximum value in the path.

    Example 2:

    Input: root = [3,3,null,4,2]
    Output: 3
    Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
    Example 3:

    Input: root = [1]
    Output: 1
    Explanation: Root is considered as good.


            Constraints:

    The number of nodes in the binary tree is in the range [1, 10^5].
    Each node's value is between [-10^4, 10^4].*/

    private void resetSum() {
        sum = 0;
    }

    private int sum = 0;

    /**
     * 统计好节点的数量
     * 思路：前序遍历，判断每个节点是否当前当前路径中的最大值，如果不大于就是好节点
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        preOrder(root, Integer.MIN_VALUE);
        return sum;
    }

    private void preOrder(TreeNode root, int parentVal) {
        if (root == null)
            return;

        if (root.val >= parentVal){
            sum++;
        }
        preOrder(root.left, Math.max(root.val,parentVal));
        preOrder(root.right, Math.max(root.val,parentVal));
    }

    public static void main(String[] args) {
        _1448_Count_Good_Nodes_in_Binary_Tree test = new _1448_Count_Good_Nodes_in_Binary_Tree();
        System.out.println(test.goodNodes(TreeMaker.array2BinaryTree(new Integer[]{3, 1, 4, 3, null, 1, 5})));
        test.resetSum();
        System.out.println(test.goodNodes(TreeMaker.array2BinaryTree(new Integer[]{3, 3, null, 4, 2})));
        test.resetSum();
        System.out.println(test.goodNodes(TreeMaker.array2BinaryTree(new Integer[]{1})));
        test.resetSum();
        System.out.println(test.goodNodes(TreeMaker.array2BinaryTree(new Integer[]{9, null, 3, 6})));
    }
}
