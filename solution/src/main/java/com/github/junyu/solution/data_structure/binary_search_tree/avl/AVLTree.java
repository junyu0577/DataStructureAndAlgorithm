package com.github.junyu.solution.data_structure.binary_search_tree.avl;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 平衡的二叉搜索树
 * 节点大于左孩子，小于右孩子
 * 左右子树高度差不能超过1
 * <p>
 * 时间复杂度O(logN)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/28 20:37
 */
public class AVLTree<Key extends Comparable, Value> {

    private class Node {

        private Node leftChild;
        private Node rightChild;
        private Key key;
        private Value value;
        private int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.height = 1;
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
        List<Key> list = new ArrayList();
        inOrder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0)
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

    public void insert(Key key, Value value) {
        root = insert(key, value, root);
    }

    private Node insert(Key key, Value value, Node node) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (node.key == key) {
            node.value = value;
        } else if (node.key.compareTo(key) < 0) {
            node.rightChild = insert(key, value, node.rightChild);
        } else {
            node.leftChild = insert(key, value, node.leftChild);
        }

        //修正字数深度
        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

        //balance
        int balanceFactor = getBalanceFactor(node);

        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.leftChild) >= 0) {
            return rightRotate(node);
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.rightChild) <= 0) {
            return leftRotate(node);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.leftChild) < 0) {
            node.leftChild = leftRotate(node.leftChild);
            return rightRotate(node);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.rightChild) > 0) {
            node.rightChild = rightRotate(node.rightChild);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * 删除某一个节点
     *
     * @param key 节点的键
     */
    public void removeNode(Key key) {
        if (root != null) {
            root = removeNode(root, key);
//            root = removeNodeByFindMaximum(root, key);
        }
    }

    /**
     * 从右子树中寻找最小值去代替要删除的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node removeNode(Node node, Key key) {

        if (node == null) {
            return null;
        }
        Node retNode;
        if (key.compareTo(node.key)>0) {
            node.rightChild = removeNode(node.rightChild, key);
            retNode =  node;
        } else if (key.compareTo(node.key)<0) {
            node.leftChild = removeNode(node.leftChild, key);
            retNode =  node;
        } else {//找到了要删除的节点
            if (node.rightChild == null) {//右孩子为空
                Node leftChild = node.leftChild;
                node.leftChild = null;
                count--;
                retNode =  leftChild;
            } else if (node.leftChild == null) {//左孩子为空
                Node rightChild = node.rightChild;
                node.rightChild = null;
                count--;
                retNode =  rightChild;
            } else {//含有左右子节点
                //minNode节点用来代替要删除的节点
                //如果不通过new的方式获取最小节点，会导致在删除最小值时造成错乱
                Node minNode = new Node(minimum(node.rightChild));
                minNode.leftChild = node.leftChild;
                minNode.rightChild = removeNode(node.rightChild,minNode.key);
                node.leftChild = node.rightChild = null;
                retNode =  minNode;
            }
        }
        if (retNode==null)
            return null;

        //修正字数深度
        retNode.height = Math.max(getHeight(retNode.leftChild), getHeight(retNode.rightChild)) + 1;

        //balance
        int balanceFactor = getBalanceFactor(retNode);

        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.leftChild) >= 0) {
            return rightRotate(retNode);
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.rightChild) <= 0) {
            return leftRotate(retNode);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.leftChild) < 0) {
            retNode.leftChild = leftRotate(retNode.leftChild);
            return rightRotate(retNode);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.rightChild) > 0) {
            retNode.rightChild = rightRotate(retNode.rightChild);
            return leftRotate(retNode);
        }

        return retNode;
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
     * 右旋转
     * 发生在元素被插入在左侧的左侧 破坏了平衡因子
     * <p>
     * y                        x
     * /   \                    /  \
     * x    T4                 z      y
     * /  \                     / \    / \
     * z  T3         ----->    T1  T2  T3  T4
     * /    \
     * T1    T2
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.leftChild;
        Node T3 = x.rightChild;

        x.rightChild = y;
        y.leftChild = T3;

        y.height = Math.max(getHeight(y.leftChild), getHeight(y.rightChild)) + 1;
        x.height = Math.max(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;

        return x;
    }

    /**
     * 左旋转
     * 发生在元素被插入在右侧的右侧 破坏了平衡因子
     * <p>
     * y                        x
     * /   \                    /  \
     * T1     x                y      z
     * / \              / \    / \
     * T2   z   ----->   T1  T2  T3  T4
     * / \
     * T3  T4
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.rightChild;
        Node T2 = x.leftChild;

        x.leftChild = y;
        y.rightChild = T2;

        y.height = Math.max(getHeight(y.leftChild), getHeight(y.rightChild)) + 1;
        x.height = Math.max(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;

        return x;
    }

    public boolean contain(int key) {
        return contain(key, root);
    }

    private boolean contain(int key, Node node) {
        if (node == null) {
            return false;
        }
        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (node.key.compareTo(key) < 0) {
            return contain(key, node.rightChild);
        } else {
            return contain(key, node.leftChild);
        }
    }

    public Value value(int key) {
        return value(key, root);
    }

    private Value value(int key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node.value;
        } else if (node.key.compareTo(key) < 0) {
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
        System.out.print(node.key + "\t");
        inOrder(node.rightChild);
    }


    private void levelOrder(Node node) {
        if (node == null)
            return;

        Queue<Node> q = new LinkedList();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.key + "\t");
            if (n.leftChild != null)
                q.add(n.leftChild);

            if (n.rightChild != null)
                q.add(n.rightChild);
        }

    }


    public static void main(String[] args) {
        int length = 100;
        AVLTree bst = new AVLTree();
        for (int i = 0; i < length; i++) {
//            int key = (int) (Math.random() * 100);
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


        for (int i=0;i<length;i++){
            bst.removeNode(i);
            if (!bst.isBalanceTree() || !bst.isBST())
                throw new RuntimeException("avl is not bst or balance tree");
        }

        System.out.println("complete!");
//        bst.levelOrder();
//        System.out.println();
//        bst.inOrder();

    }
}
