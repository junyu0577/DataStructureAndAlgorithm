package com.github.junyu.solution.data_structure.binary_search_tree.trie;

import java.util.TreeMap;

/**
 * 字典树/前缀树
 * 查询和添加元素的操作和集合中元素的数量无关，取决于元素本身的长度
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018-08-12 16:20
 */
public class Trie {

    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * 向树中添加一个单词
     *
     * @param word 要添加的单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询树中是否包含word单词
     *
     * @param word 要查询的单词
     * @return true为包含
     */
    public boolean contain(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询树中是否存在以prefix为前缀的单词
     *
     * @param prefix 要查询的前缀
     * @return true 存在
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}
