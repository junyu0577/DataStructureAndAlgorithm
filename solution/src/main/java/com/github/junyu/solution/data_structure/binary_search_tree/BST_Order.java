package com.github.junyu.solution.data_structure.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树的遍历
 * 深度优先(前中后序遍历)
 * 广度优先(层序遍历)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018-06-28 22:01
 */
public class BST_Order {

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

    public BST_Order() {
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

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftChild);
        System.out.println(node.key);
        inOrder(node.rightChild);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.println(node.key);
    }

    public void destroy() {
        destroy(root);
    }

    private void destroy(Node node) {
        if (node == null) {
            return;
        }
        destroy(node.leftChild);
        destroy(node.rightChild);
        node.value = null;
        count--;
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();

            if (node.leftChild != null) {
                q.add(node.leftChild);
            }

            if (node.rightChild != null) {
                q.add(node.rightChild);
            }

            System.out.println(node.key);
        }
    }

    public static void main(String[] args) {
        BST_Order bst = new BST_Order();
//        for (int i = 0; i < 10; i++) {
//            bst.insert(i, String.valueOf(i));
//        }
        bst.insert(8, String.valueOf("8"));
        bst.insert(7, String.valueOf("7"));
        bst.insert(99, String.valueOf("99"));
        bst.insert(88, String.valueOf("88"));
        bst.insert(6, String.valueOf("6"));
        bst.insert(100, String.valueOf("100"));

//        bst.destroy();
        bst.levelOrder();

        System.out.println("size:" + bst.size());
    }
}
