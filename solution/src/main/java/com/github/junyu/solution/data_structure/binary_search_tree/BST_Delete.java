package com.github.junyu.solution.data_structure.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树节点的删除
 * 删除最大值、最小值以及任意节点（Hibbard Deletion）
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018-06-28 22:01
 */
public class BST_Delete {

    private class Node {

        private Node leftChild;
        private Node rightChild;
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.leftChild = node.leftChild;
            this.rightChild = node.rightChild;
        }


    }

    private Node root;
    private int count;

    public BST_Delete() {
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

    /**
     * 返回最小的节点
     *
     * @param node
     * @return
     */
    public Node minimum(Node node) {
        if (node.leftChild == null) {
            return node;
        } else {
            return minimum(node.leftChild);
        }
    }


    /**
     * 返回最大的节点
     *
     * @param node
     * @return
     */
    public Node maximum(Node node) {
        if (node.rightChild == null) {
            return node;
        } else {
            return maximum(node.rightChild);
        }
    }

    /**
     * 删除最大值
     *
     * @return
     */
    public void removeMaximum() {
        if (root != null) {
            root = removeMaximum(root);
        }
    }

    /**
     * 删除最小值
     *
     * @return
     */
    public void removeMinimum() {
        if (root != null) {
            root = removeMinimum(root);
        }
    }

    /**
     * 删除某一个节点
     *
     * @param key 节点的键
     */
    public void removeNode(int key) {
        if (root != null) {
            root = removeNode(root, key);
        }
    }

    private Node removeMinimum(Node node) {
        if (node.leftChild == null) {
            Node rightNode = node.rightChild;
            node.rightChild = null;
            count--;
            return rightNode;
        }
        node.leftChild = removeMinimum(node.leftChild);
        return node;
    }

    private Node removeMaximum(Node node) {
        if (node.rightChild == null) {
            Node leftNode = node.leftChild;
            node.leftChild = null;
            count--;
            return leftNode;
        }
        node.rightChild = removeMaximum(node.rightChild);
        return node;
    }

    private Node removeNode(Node node, int key) {

        if (node == null) {
            return null;
        }
        if (key > node.key) {
            node.rightChild = removeNode(node.rightChild, key);
            return node;
        } else if (key < node.key) {
            node.leftChild = removeNode(node.leftChild, key);
            return node;
        } else {//找到了要删除的节点
            if (node.rightChild == null) {//右孩子为空
                Node leftChild = node.leftChild;
                node.leftChild = null;
                count--;
                return leftChild;
            } else if (node.leftChild == null) {//左孩子为空
                Node rightChild = node.rightChild;
                node.rightChild = null;
                count--;
                return rightChild;
            } else {//含有左右子节点
                //minNode节点用来代替要删除的节点
                //如果不通过new的方式获取最小节点，会导致在删除最小值时造成错乱
                Node minNode = new Node(minimum(node.rightChild));
                minNode.leftChild = node.leftChild;
                minNode.rightChild = removeMinimum(node.rightChild);
                node.leftChild = node.rightChild = null;
                return minNode;
            }
        }
    }


    public static void main(String[] args) {
        BST_Delete bst = new BST_Delete();
//        for (int i = 0; i < 10; i++) {
//            bst.insert(i, String.valueOf(i));
//        }
        bst.insert(41, String.valueOf("41"));
        bst.insert(59, String.valueOf("59"));
        bst.insert(50, String.valueOf("50"));
        bst.insert(61, String.valueOf("61"));
        bst.insert(42, String.valueOf("42"));
        bst.insert(53, String.valueOf("53"));
        bst.insert(63, String.valueOf("63"));
        bst.insert(60, String.valueOf("60"));

//        testRemoveMaxNode(bst);
//        testRemoveMinNode(bst);

        testRemoveNode(bst, 59);

        System.out.println("size:" + bst.size());
    }

    /**
     * 测试删除某一个节点
     *
     * @param bst
     */
    private static void testRemoveNode(BST_Delete bst, int key) {
        bst.levelOrder();
        bst.removeNode(key);
        System.out.println("---------");
        bst.levelOrder();
    }

    /**
     * 测试删除最大的节点
     *
     * @param bst
     */
    private static void testRemoveMaxNode(BST_Delete bst) {
        bst.levelOrder();
        bst.removeMaximum();
        System.out.println("---------");
        bst.levelOrder();
    }

    /**
     * 测试删除最小的节点
     *
     * @param bst
     */
    private static void testRemoveMinNode(BST_Delete bst) {
        bst.levelOrder();
        bst.removeMinimum();
        System.out.println("---------");
        bst.levelOrder();
    }
}
