package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.binary_search_tree.trie.Trie;

public class TrieTest {
    public static void main(String[] args) {
        String words[] = {"java", "kotlin", "android"};
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++)
            trie.add(words[i]);

        System.out.println("size: " + trie.size());

        for (int i = 0; i < words.length; i++)
            System.out.println("contain " + words[i] + " :" + trie.contain(words[i]));

        System.out.println(trie.contain("lua"));
        System.out.println(trie.isPrefix("and"));
        System.out.println(trie.isPrefix("anc"));

    }
}
