package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class _1609_Even_Odd_Tree {

   /* A binary tree is named Even-Odd if it meets the following conditions:

    The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
    For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
    For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
    Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

    Example 1:

    Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
    Output: true
    Explanation: The node values on each level are:
    Level 0: [1]
    Level 1: [10,4]
    Level 2: [3,7,9]
    Level 3: [12,8,6,2]
    Since levels 0 and 2 are all odd and increasing, and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.

    Example 2:


    Input: root = [5,4,2,3,3,7]
    Output: false
    Explanation: The node values on each level are:
    Level 0: [5]
    Level 1: [4,2]
    Level 2: [3,3,7]
    Node values in the level 2 must be in strictly increasing order, so the tree is not Even-Odd.
            Example 3:



    Input: root = [5,9,1,3,5,7]
    Output: false
    Explanation: Node values in the level 1 should be even integers.
    Example 4:

    Input: root = [1]
    Output: true
    Example 5:

    Input: root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
    Output: true
             

    Constraints:

    The number of nodes in the tree is in the range [1, 105].
            1 <= Node.val <= 106
*/

    /**
     * 奇偶树
     * 满足以下条件：
     * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
     * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
     * 使用层序遍历，逐行判断元素即可。
     *
     *
     * Runtime: 7 ms, faster than 100.00% of Java online submissions for Even Odd Tree.
     * Memory Usage: 55.8 MB, less than 80.49% of Java online submissions for Even Odd Tree.
     *
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if ((root.val&1)==0){
            return false;
        }
        boolean isEven = false;

        if (root.left!=null)
            linkedList.add(root.left);
        if (root.right!=null)
            linkedList.add(root.right);

        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            int startNumber;
            if (isEven) {//even
                startNumber = Integer.MIN_VALUE;
            } else {
                startNumber = Integer.MAX_VALUE;
            }
            for (int i=0;i<size;i++){
                TreeNode node =  linkedList.poll();
                int cur =  node.val;
                if (isEven){// increasing
                   if (startNumber>=cur || (cur&1)==0){
                        return false;
                   }
                } else {//decreasing
                    if (startNumber<=cur || (cur&1)==1){
                        return false;
                    }
                }
                startNumber = cur;
                if (node.left!=null)
                    linkedList.add(node.left);
                if (node.right!=null)
                    linkedList.add(node.right);
            }
            isEven = !isEven;
        }

        return true;
    }

    public static void main(String[] args) {
        _1609_Even_Odd_Tree test = new _1609_Even_Odd_Tree();
        System.out.println(test.isEvenOddTree(TreeMaker.array2BinaryTree(new Integer[]{1,10,4,3,null,7,9,12,8,6,null,null,2})));
        System.out.println(test.isEvenOddTree(TreeMaker.array2BinaryTree(new Integer[]{5,4,2,3,3,7})));
        System.out.println(test.isEvenOddTree(TreeMaker.array2BinaryTree(new Integer[]{5,9,1,3,5,7})));
        System.out.println(test.isEvenOddTree(TreeMaker.array2BinaryTree(new Integer[]{1})));
        System.out.println(test.isEvenOddTree(TreeMaker.array2BinaryTree(new Integer[]{11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17})));
    }
}
