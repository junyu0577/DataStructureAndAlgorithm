package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _2236_Root_Equals_Sum_of_Children {

/*
    You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.

    Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.



    Example 1:


    Input: root = [10,4,6]
    Output: true
    Explanation: The values of the root, its left child, and its right child are 10, 4, and 6,
    respectively.
    10 is equal to 4 + 6, so we return true.


    Example 2:


    Input: root = [5,3,1]
    Output: false
    Explanation: The values of the root, its left child, and its right child are 5, 3, and 1,
    respectively.
    5 is not equal to 3 + 1, so we return false.


    Constraints:

    The tree consists only of the root, its left child, and its right child.
            -100 <= Node.val <= 100
*/

    /**
     * 判断根结点是否等于子结点之和
     *
     * 凑数题 题量喜+1
     *
     * @param root
     * @return
     */
    public boolean checkTree(TreeNode root) {
        return root.val == (root.right.val + root.left.val) ;
    }


    public static void main(String [] args) {
        _2236_Root_Equals_Sum_of_Children test = new _2236_Root_Equals_Sum_of_Children();
        System.out.println(test.checkTree(TreeMaker.array2BinaryTree(new Integer[]{10,4,6})));
        System.out.println(test.checkTree(TreeMaker.array2BinaryTree(new Integer[]{5,3,1})));
    }

}
