package com.github.junyu.solution.leetCode.medium.design;

public class _211_Add_and_Search_Word_Data_structure_design {


/*
    Design a data structure that supports the following two operations:

    void addWord(word)
    bool search(word)
    search(word) can search a literal word or a regular expression string
    containing only letters a-z or .. A . means it can represent any one letter.

            Example:

    addWord("bad")
    addWord("dad")
    addWord("mad")
    search("pad") -> false
    search("bad") -> true
    search(".ad") -> true
    search("b..") -> true
    Note:
    You may assume that all words are consist of lowercase letters a-z.*/

    private class Node {
        private boolean isWord;
        private Node next[] = new Node[26];
    }

    private Node root;

    /**
     * 这个在208的基础上，考查'.'的匹配，'.'可以代表任意字符
     * 使用进行递归往下进行比较，如果遇到的字符不是'.'，那么判断逻辑和之前一致，只要不为空就匹配，然后继续
     * 往下进行下一个字符的匹配。如果遇到的字符是'.'，那么就需要对下一个任意节点都又可能匹配上字符，需要全部进行匹配，只要子树中
     * 存在字符串，那么结果就是存在指定的元素
     *
     */
    public _211_Add_and_Search_Word_Data_structure_design() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return patternWord(root, word, 0);
    }

    private boolean patternWord(Node cur, String word, int index) {
      if (word.length()==index){
          return cur.isWord;
      }

      char c = word.charAt(index);
      if ('.' != c){//不是'.'字符
          if (cur.next[c-'a']==null)
              return false;
          return patternWord(cur.next[c-'a'],word,index+1);
      } else {
          for (int i=0;i<cur.next.length;i++){
            if (cur.next[i]!=null && patternWord(cur.next[i],word,index+1))
                return true;
          }
          return false;
      }
    }

    public static void main(String[] args) {
        _211_Add_and_Search_Word_Data_structure_design add_and_search_word_data_structure_design = new _211_Add_and_Search_Word_Data_structure_design();
        add_and_search_word_data_structure_design.addWord("a");
        add_and_search_word_data_structure_design.addWord("a");
        System.out.println(add_and_search_word_data_structure_design.search("."));
        System.out.println(add_and_search_word_data_structure_design.search("a"));
        System.out.println(add_and_search_word_data_structure_design.search("aa"));
        System.out.println(add_and_search_word_data_structure_design.search(".a"));
        System.out.println(add_and_search_word_data_structure_design.search("a."));
    }

}
