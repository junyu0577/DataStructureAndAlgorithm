package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _1315_Sum_of_Nodes_with_Even_Valued_Grandparent {

   /* Given a binary tree, return the sum of values of nodes with even-valued grandparent.
        (A grandparent of a node is the parent of its parent, if it exists.)

    If there are no nodes with an even-valued grandparent, return 0.



    Example 1:



    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    Output: 18
    Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value
    grandparents.


    Constraints:

    The number of nodes in the tree is between 1 and 10^4.
    The value of nodes is between 1 and 100.*/

    private int ans;

    /**
     * 祖父节点值为偶数的节点和
     * 思路：前序遍历，如果当前节点为偶数则累加其4个孙子节点的值到ans(如果存在的话)。
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        preOrder(root);
        return ans;
    }

    private void preOrder(TreeNode root) {
        if (root == null)
            return;

        if ((root.val & 1) == 0) {
            if (root.left != null && root.left.left != null) {
                ans += root.left.left.val;
            }
            if (root.left != null && root.left.right != null) {
                ans += root.left.right.val;
            }
            if (root.right != null && root.right.left != null) {
                ans += root.right.left.val;
            }
            if (root.right != null && root.right.right != null) {
                ans += root.right.right.val;
            }
        }
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        _1315_Sum_of_Nodes_with_Even_Valued_Grandparent test = new _1315_Sum_of_Nodes_with_Even_Valued_Grandparent();
        System.out.println(test.sumEvenGrandparent(TreeMaker.array2BinaryTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9,
                null, 1, 4, null,
                null, null, 5})));
    }
}
