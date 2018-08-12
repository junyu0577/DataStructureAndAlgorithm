package com.github.junyu.solution.leetCode.medium.design;


public class _208_Implement_Trie_Prefix_Tree {


/*

    Implement a trie with insert, search, and startsWith methods.

            Example:

    Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
    Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.
*/

    private class Node {
        private boolean isWord;
        private Node next[] = new Node[26];

        public Node(boolean isWord) {
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * 字典树的设计，题目中说明了字符范围a-z，那么只需要开辟一个26长度的数组就可以
     */
    public _208_Implement_Trie_Prefix_Tree() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new Node();
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        _208_Implement_Trie_Prefix_Tree implement_trie_prefix_tree = new _208_Implement_Trie_Prefix_Tree();
        implement_trie_prefix_tree.insert("apple");
        System.out.println(implement_trie_prefix_tree.search("apple"));
        System.out.println(implement_trie_prefix_tree.startsWith("app"));
        System.out.println(implement_trie_prefix_tree.startsWith("acc"));
    }

}
