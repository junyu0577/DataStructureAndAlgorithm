package com.github.junyu.solution.data_structure.binary_search_tree.avl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 平衡的二叉搜索树
 * 节点大于左孩子，小于右孩子
 * 左右子树高度差不能超过1
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/28 20:37
 */
public class AVLTree {

    private class Node {

        private Node leftChild;
        private Node rightChild;
        private int key;
        private String value;
        private int height;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }


    }

    private Node root;
    private int count;

    public AVLTree() {
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 获取node节点的高度
     *
     * @param node
     */
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    /**
     * 计算节点的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }

    /**
     * 返回是否是平衡树
     *
     * @return
     */
    private boolean isBalanceTree() {
        return isBalanceTree(root);
    }

    private boolean isBalanceTree(Node node) {
        if (node == null)
            return true;
        if (Math.abs(getBalanceFactor(root)) > 1)
            return false;
        return isBalanceTree(root.leftChild) && isBalanceTree(root.rightChild);
    }

    /**
     * 返回是否是二叉搜索树
     *
     * @return
     */
    private boolean isBST() {
        List<Integer> list = new ArrayList();
        inOrder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i))
                return false;
        }

        return true;
    }

    private void inOrder(Node node, List list) {

        if (node == null)
            return;

        inOrder(node.leftChild, list);
        list.add(node.key);
        inOrder(node.rightChild, list);
    }

    public void insert(int key, String value) {
        root = insert(key, value, root);
    }

    private Node insert(int key, String value, Node node) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (node.key == key) {
            node.value = value;
        } else if (node.key < key) {
            node.rightChild = insert(key, value, node.rightChild);
        } else {
            node.leftChild = insert(key, value, node.leftChild);
        }

        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        if (Math.abs(getBalanceFactor(node)) > 1)
            System.out.println(getBalanceFactor(node));
        return node;
    }

    public boolean contain(int key) {
        return contain(key, root);
    }

    private boolean contain(int key, Node node) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        } else if (node.key < key) {
            return contain(key, node.rightChild);
        } else {
            return contain(key, node.leftChild);
        }
    }

    public String value(int key) {
        return value(key, root);
    }

    private String value(int key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node.value;
        } else if (node.key < key) {
            return value(key, node.rightChild);
        } else {
            return value(key, node.leftChild);
        }
    }


    public static void main(String[] args) {
        AVLTree bst = new AVLTree();
        for (int i = 0; i < 5; i++) {
            bst.insert(i, String.valueOf(i));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(bst.contain(i));
        }

//        for (int i = 0; i < 6; i++) {
//            System.out.println("value:" + bst.value(i));
//        }

        System.out.println("is balance : " + bst.isBalanceTree());
        System.out.println("is BST : " + bst.isBST());

    }
}
