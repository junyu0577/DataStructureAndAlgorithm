package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _1325_Delete_Leaves_With_a_Given_Value {

    /*Given a binary tree root and an integer target, delete all the leaf
    nodes with value target.

    Note that once you delete a leaf node with value target, if it's parent
    node becomes a leaf node and has the value target, it should also be
    deleted (you need to continue doing that until you can't).

    Example 1:

    Input: root = [1,2,3,2,null,2,4], target = 2
    Output: [1,null,3,null,4]
    Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
    After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
    Example 2:

    Input: root = [1,3,3,3,2], target = 3
    Output: [1,3,null,null,2]
    Example 3:

    Input: root = [1,2,null,2,null,2], target = 2
    Output: [1]
    Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
    Example 4:

    Input: root = [1,1,1], target = 1
    Output: []
    Example 5:

    Input: root = [1,2,3], target = 1
    Output: [1,2,3]


    Constraints:

            1 <= target <= 1000
    The given binary tree will have between 1 and 3000 nodes.
    Each node's value is between [1, 1000].*/

    /**
     * 删除value为target的所有叶子节点
     * 思路：通过后续遍历，当节点为叶子节点并且value和target相等便返回null。
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return postOrder(root, target);
    }

    private TreeNode postOrder(TreeNode root, int target) {
        if (root == null)
            return null;

        root.left = postOrder(root.left,target);
        root.right = postOrder(root.right,target);

        if (root.left==null && root.right==null && root.val==target)
            return null;

        return root;
    }

    public static void main(String[] args) {
        _1325_Delete_Leaves_With_a_Given_Value test = new _1325_Delete_Leaves_With_a_Given_Value();
        System.out.println(test.removeLeafNodes(TreeMaker.array2BinaryTree(
                new Integer[]{1, 2, 3, 2, null, 2, 4}), 2));
    }
}
