package com.github.junyu.solution.leetCode.medium.design;

import com.github.junyu.solution.data_structure.utils.TreeMaker;
import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

import java.util.LinkedList;

public class _449_Serialize_and_Deserialize_BST {

    /*Serialization is the process of converting a data structure or object into a sequence of bits so that it
    can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed
     later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
     serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can
     be serialized to a string and this string can be deserialized to the original tree structure.

    The encoded string should be as compact as possible.

    Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
     should be stateless.
*/

    /**
     * 序列化和反序列化二叉搜索树
     * 思路：序列化通过层序遍历bst，将当前层的所有节点的左右子节点的value按顺便保存在sb中，如果子节点是空的，则写入null.
     * 反序列化时，通过逗号先将字符串转为数组，然后总体思路同层序遍历（从链表中取一个元素，并将非空的左右子节点插入到链表）
     * ，每次从数组中读取两个元素，作为当前节点的左右子节点并插入到链表中。
     *
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";
            StringBuilder sb = new StringBuilder();
            LinkedList<TreeNode> list = new LinkedList<>();
            sb.append(root.val);
            list.add(root);
            while (!list.isEmpty()) {
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = list.poll();
                    if (node.left != null) {
                        list.add(node.left);
                        sb.append("," + node.left.val);
                    } else {
                        sb.append(",null");
                    }
                    if (node.right != null) {
                        list.add(node.right);
                        sb.append("," + node.right.val);
                    } else {
                        sb.append(",null");
                    }
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data))
                return null;

            String[] arr = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            for (int i = 1; i < arr.length; i += 2) {
                TreeNode node = list.poll();
                if (!"null".equals(arr[i])) {
                    TreeNode leftChild = new TreeNode(Integer.parseInt(arr[i]));
                    node.left = leftChild;
                    list.add(leftChild);
                }
                if (!"null".equals(arr[i + 1])) {
                    TreeNode rightChild = new TreeNode(Integer.parseInt(arr[i + 1]));
                    node.right = rightChild;
                    list.add(rightChild);
                }
            }
            return root;
        }
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        String str = codec.serialize(TreeMaker.array2BinaryTree(new Integer[]{2,null,3}));
        System.out.println(str);
        System.out.println(codec.deserialize(str));
    }
}
