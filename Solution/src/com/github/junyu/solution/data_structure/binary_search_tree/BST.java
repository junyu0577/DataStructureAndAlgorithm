package com.github.junyu.solution.data_structure.binary_search_tree;

/**
 * 二分搜索树
 * 节点大于左孩子，小于右孩子
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/28 20:37
 */
public class BST {

    private class Node {

        private Node leftChild;
        private Node rightChild;
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }


    }

    private Node root;
    private int count;

    public BST() {
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
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
        BST bst = new BST();
        for (int i = 0; i < 5; i++) {
            bst.insert(i, String.valueOf(i));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(bst.contain(i));
        }

        for (int i = 0; i < 6; i++) {
            System.out.println("value:"+bst.value(i));
        }

    }
}
