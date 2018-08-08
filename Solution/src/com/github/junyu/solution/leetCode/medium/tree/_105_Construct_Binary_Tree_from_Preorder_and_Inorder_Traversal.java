package com.github.junyu.solution.leetCode.medium.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

   /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

            Note:
    You may assume that duplicates do not exist in the tree.

            For example, given

    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:

            3
            / \
            9  20
            /  \
            15   7
*/

    /**
     * 根据前序和中序遍历建立二叉树
     * 首先前序数组的第一位就是树的root，而在中序数组中，以root为中心，左边是左子树，右边是右子树。
     * 根据以上信息可以得出，如果root的左边没有元素，那么左子树即为空，右边同理。
     * 核心思路就是:依次从preorder中取出元素，然后在inorder中查看其位置，拆分左右子树,向下递归,取出preorder中的元素，查看inorder位置，拆分。。这么循环。
     * 直到left>right，子节点为空
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int index, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index]);

        int nodeIndex = -1;
        for (int i = left; i <= right; i++) {
            if (node.val == inorder[i]) {
                nodeIndex = i;
                break;
            }
        }

        node.left = build(preorder,inorder,index+1,left,nodeIndex-1);
        node.right = build(preorder,inorder,nodeIndex+index+1-left,nodeIndex+1,right);

        return node;

    }

    public static void main(String[] args) {
        int arr[] = {3, 9, 20, 15, 7};
        int arr2[] = {9, 3, 15, 20, 7};

//        int arr[] = {1, 2, 4, 3};
//        int arr2[] = {1, 2, 3, 4};

        _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal test = new _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        TreeNode tree = test.buildTree(arr, arr2);
        System.out.println(tree);

        System.out.println();

    }

}
