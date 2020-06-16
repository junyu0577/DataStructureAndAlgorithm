package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.HashMap;

public class _1261_Find_Elements_in_a_Contaminated_Binary_Tree {

    /*Given a binary tree with the following rules:

    root.val == 0
    If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
    If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
    Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

    You need to first recover the binary tree and then implement the FindElements class:

    FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
    bool find(int target) Return if the target value exists in the recovered binary tree.

    Example 1:

    Input
    ["FindElements","find","find"]
            [[[-1,null,-1]],[1],[2]]
        Output
    [null,false,true]
        Explanation
        FindElements findElements = new FindElements([-1,null,-1]);
    findElements.find(1); // return False
    findElements.find(2); // return True
    Example 2:



    Input
    ["FindElements","find","find","find"]
        [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
    Output
    [null,true,true,false]
    Explanation
    FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
    findElements.find(1); // return True
    findElements.find(3); // return True
    findElements.find(5); // return False
    Example 3:



    Input
    ["FindElements","find","find","find","find"]
        [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
    Output
    [null,true,false,false,true]
    Explanation
    FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
    findElements.find(2); // return True
    findElements.find(3); // return False
    findElements.find(4); // return False
    findElements.find(5); // return True

    Constraints:

    TreeNode.val == -1
    The height of the binary tree is less than or equal to 20
    The total number of nodes is between [1, 10^4]
    Total calls of find() is between [1, 10^4]
            0 <= target <= 10^6*/

    /**
     * 在受污染的二叉树中查找元素
     * 思路：把二叉树各点的值保持到map中，在find的时候获取到的对象不为空就说明找得到指定元素。
     */
    static class FindElements {
        private HashMap<Integer, Boolean> map;

        public FindElements(TreeNode root) {
            map = new HashMap<>();
            preOrder(root, 0);
        }

        private void preOrder(TreeNode root, int val) {
            if (root == null)
                return;

            map.put(val, true);
            preOrder(root.left, val * 2 + 1);
            preOrder(root.right, val * 2 + 2);
        }

        public boolean find(int target) {
            return map.get(target) != null;
        }
    }

    public static void main(String[] args) {
        FindElements findElements = new
                FindElements(TreeMaker.array2BinaryTree(new Integer[]{-1, -1, -1, -1, -1}));
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
    }
}
