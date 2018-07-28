package com.github.junyu.solution.data_structure.binary_search_tree.avl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 平衡的二叉搜索树
 * 节点大于左孩子，小于右孩子
 * 左右子树高度差不能超过1
 *
 * 时间复杂度O(logN)
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
        if (Math.abs(getBalanceFactor(node)) > 1)
            return false;
        return isBalanceTree(node.leftChild) && isBalanceTree(node.rightChild);
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

        //修正字数深度
        node.height = Math.max(getHeight(node.leftChild),getHeight(node.rightChild))+1;

        //balance
        int balanceFactor = getBalanceFactor(node);

        //LL
        if (balanceFactor>1 && getBalanceFactor(node.leftChild)>=0){
            return rightRotate(node);
        }

        //RR
        if (balanceFactor<-1 && getBalanceFactor(node.rightChild)<=0){
            return leftRotate(node);
        }

        //LR
        if (balanceFactor>1 && getBalanceFactor(node.leftChild)<0){
            node.leftChild = leftRotate(node.leftChild);
            return rightRotate(node);
        }

        //RL
        if (balanceFactor<-1 && getBalanceFactor(node.rightChild)>0){
            node.rightChild = rightRotate(node.rightChild);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * 右旋转
     * 发生在元素被插入在左侧的左侧 破坏了平衡因子
     *
     *            y                        x
     *          /   \                    /  \
     *         x    T4                 z      y
     *       /  \                     / \    / \
     *      z  T3         ----->    T1  T2  T3  T4
     *     /    \
     *    T1    T2
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.leftChild;
        Node T3 = x.rightChild;

        x.rightChild = y;
        y.leftChild = T3;

        y.height = Math.max(getHeight(y.leftChild),getHeight(y.rightChild))+1;
        y.height = Math.max(getHeight(x.leftChild),getHeight(x.rightChild))+1;

        return x;
    }

    /**
     * 左旋转
     * 发生在元素被插入在右侧的右侧 破坏了平衡因子
     *
     *           y                        x
     *         /   \                    /  \
     *        T1     x                y      z
     *              / \              / \    / \
     *            T2   z   ----->   T1  T2  T3  T4
     *           / \
     *          T3  T4
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
       Node x = y.rightChild;
       Node T2 = x.leftChild;

       x.leftChild = y;
       y.rightChild = T2;

       y.height = Math.max(getHeight(y.leftChild),getHeight(y.rightChild))+1;
       x.height = Math.max(getHeight(x.leftChild),getHeight(x.rightChild))+1;

       return x;
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

    private void levelOrder() {
        levelOrder(root);
    }

    private void inOrder() {

        inOrder(root);

    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.value + "\t");
        inOrder(node.rightChild);
    }


    private void levelOrder(Node node) {
        if (node == null)
            return;

        Queue<Node> q = new LinkedList();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.value + "\t");
            if (n.leftChild != null)
                q.add(n.leftChild);

            if (n.rightChild != null)
                q.add(n.rightChild);
        }

    }


    public static void main(String[] args) {
        AVLTree bst = new AVLTree();
        for (int i = 0; i < 100; i++) {
            bst.insert(i, String.valueOf(i));
        }
//        for (int i = 0; i < 6; i++) {
//            System.out.println(bst.contain(i));
//        }

//        for (int i = 0; i < 6; i++) {
//            System.out.println("value:" + bst.value(i));
//        }

        System.out.println("is balance : " + bst.isBalanceTree());
        System.out.println("is BST : " + bst.isBST());

        bst.levelOrder();
        System.out.println();
        bst.inOrder();

    }
}
