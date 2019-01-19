package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _720_Longest_Word_in_Dictionary {

    /*Given a list of strings words representing an English Dictionary,
    find the longest word in words that can be built one character at a time
    by other words in words. If there is more than one possible answer,
    return the longest word with the smallest lexicographical order.

    If there is no answer, return the empty string.
            Example 1:

    Input:
    words = ["w","wo","wor","worl", "world"]
    Output: "world"
    Explanation:
    The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
    Example 2:

    Input:
    words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    Output: "apple"
    Explanation:
    Both "apply" and "apple" can be built from other words in the dictionary.
    However, "apple" is lexicographically smaller than "apply".

    Note:

    All the strings in the input will only contain lowercase letters.
    The length of words will be in the range [1, 1000].
    The length of words[i] will be in the range [1, 30].

*/

    /**
     * 找出数组中能够形成字典的最长单词。
     * 首先多数组进行一次排序，这样整个列表就按字典序进行排列，字母少的也排在了多的前面。
     * 然后利用hash表的唯一性，不断的往列表中进行保存元素。
     * 保存的对象是只要合服单一字符或者当前字符串去掉末尾后存在在set集合中，那么我们就会保存，
     * 同时判断当前的字符串的长度，如果大于上一个ans的长度，那么就进行覆盖操作。
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> hash = new HashSet<>();
        String ans = "";

        for (String word : words) {
            if (word.length() == 1 || hash.contains(word.substring(0, word.length() - 1))) {
                ans = word.length() > ans.length() ? word : ans;
                hash.add(word);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        _720_Longest_Word_in_Dictionary longest_word_in_dictionary = new _720_Longest_Word_in_Dictionary();
        System.out.println(longest_word_in_dictionary.longestWord(new String[]{"a", "aa", "b", "bb", "bbb"}));
    }
}
