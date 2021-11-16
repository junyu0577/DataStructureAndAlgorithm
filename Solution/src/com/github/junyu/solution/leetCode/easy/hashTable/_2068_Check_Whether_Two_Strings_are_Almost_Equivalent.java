package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.HashMap;
import java.util.Map;

public class _2068_Check_Whether_Two_Strings_are_Almost_Equivalent {

/*
    Two strings word1 and word2 are considered almost equivalent if the differences between the
     frequencies of each letter from 'a' to 'z' between word1 and word2 is at most 3.

    Given two strings word1 and word2, each of length n, return true if word1 and word2 are
    almost equivalent, or false otherwise.

    The frequency of a letter x is the number of times it occurs in the string.



    Example 1:

    Input: word1 = "aaaa", word2 = "bccb"
    Output: false
    Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb".
    The difference is 4, which is more than the allowed 3.


    Example 2:

    Input: word1 = "abcdeef", word2 = "abaaacc"
    Output: true
    Explanation: The differences between the frequencies of each letter in word1 and word2 are at most 3:
            - 'a' appears 1 time in word1 and 4 times in word2. The difference is 3.
            - 'b' appears 1 time in word1 and 1 time in word2. The difference is 0.
            - 'c' appears 1 time in word1 and 2 times in word2. The difference is 1.
            - 'd' appears 1 time in word1 and 0 times in word2. The difference is 1.
            - 'e' appears 2 times in word1 and 0 times in word2. The difference is 2.
            - 'f' appears 1 time in word1 and 0 times in word2. The difference is 1.


    Example 3:

    Input: word1 = "cccddabba", word2 = "babababab"
    Output: true
    Explanation: The differences between the frequencies of each letter in word1 and word2 are at most 3:
            - 'a' appears 2 times in word1 and 4 times in word2. The difference is 2.
            - 'b' appears 2 times in word1 and 5 times in word2. The difference is 3.
            - 'c' appears 3 times in word1 and 0 times in word2. The difference is 3.
            - 'd' appears 2 times in word1 and 0 times in word2. The difference is 2.


    Constraints:

    n == word1.length == word2.length
1 <= n <= 100
    word1 and word2 consist only of lowercase English letters.
    */

    /**
     * 2068. 检查两个字符串是否几乎相等(每一个字母出现频率之差都 不超过 3)
     * 建立哈希表分别统计字符出现的次数，然后遍历哈希表，当发现两个相同的字符出现的频率差值大于3时，返回false。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check Whether Two Strings are Almost Equivalent.
     * Memory Usage: 37.5 MB, less than 62.50% of Java online submissions for Check Whether Two Strings are Almost Equivalent.
     * 
     * @param word1
     * @param word2
     * @return
     */
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int hash [] = new int[26];
        int hash2 [] = new int[26];
        for (int i=0;i<word1.length();i++){
            hash[word1.charAt(i)-'a']++;
        }
        for (int i=0;i<word2.length();i++){
            hash2[word2.charAt(i)-'a']++;
        }


        for (int i=0;i<hash.length;i++){
            if (Math.abs(hash[i]-hash2[i])>3)
                return false;
        }

        return true;
    }



    public static void main(String [] args) {
        _2068_Check_Whether_Two_Strings_are_Almost_Equivalent test = new _2068_Check_Whether_Two_Strings_are_Almost_Equivalent();
        System.out.println(test.checkAlmostEquivalent("aaaa",  "bccb"));
        System.out.println(test.checkAlmostEquivalent("abcdeef",  "abaaacc"));
        System.out.println(test.checkAlmostEquivalent("cccddabba", "babababab"));
        System.out.println(test.checkAlmostEquivalent("zzzyyy","iiiiii"));
    }
}
