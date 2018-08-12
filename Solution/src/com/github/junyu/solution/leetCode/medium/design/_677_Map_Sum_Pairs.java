package com.github.junyu.solution.leetCode.medium.design;


public class _677_Map_Sum_Pairs {

/*
    Implement a MapSum class with insert, and sum methods.

    For the method insert, you'll be given a pair of (string, integer).
    The string represents the key and the integer represents the value. If the key already existed,
    then the original key-value pair will be overridden to the new one.

    For the method sum, you'll be given a string representing the prefix,
    and you need to return the sum of all the pairs' value whose key starts with the prefix.

            Example 1:
    Input: insert("apple", 3), Output: Null
    Input: sum("ap"), Output: 3
    Input: insert("app", 2), Output: Null
    Input: sum("ap"), Output: 5*/


    private class Node {
        private int val;
        private Node[] next = new Node[26];

        public Node(int val) {
            this.val = val;
        }

        public Node() {
            this(0);
        }

    }

    private Node root;

    /**
     * 给符合前缀的所有的字符串计算总和
     * 求sum的时候先通过prefix遍历到树的prefix位置，然后从prefix开始计算余下的所有节点的val总和
     */
    public _677_Map_Sum_Pairs() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next[c-'a'] == null)
                return 0;
            cur = cur.next[c-'a'];
        }

        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.val;

      for (int i=0;i<node.next.length;i++){
          if (node.next[i]!=null)
            res+=sum(node.next[i]);
      }

        return res;
    }


    public static void main(String[] args) {
        _677_Map_Sum_Pairs map_sum_pairs = new _677_Map_Sum_Pairs();
        map_sum_pairs.insert("apple", 3);
        System.out.println(map_sum_pairs.sum("ap"));
        map_sum_pairs.insert("app", 2);
        System.out.println(map_sum_pairs.sum("ap"));
    }

}
