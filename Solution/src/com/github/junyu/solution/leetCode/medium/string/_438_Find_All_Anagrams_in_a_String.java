package com.github.junyu.solution.leetCode.medium.string;

import java.util.ArrayList;
import java.util.List;

public class _438_Find_All_Anagrams_in_a_String {

    /*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
     20,100.

    The order of output does not matter.

            Example 1:

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
            [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
    Example 2:

    Input:
    s: "abab" p: "ab"

    Output:
            [0, 1, 2]

    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".*/

    /**
     * 找到字符串中所有字母异位词(字母异位词指字母相同，但排列不同的字符串)
     * 思路：利用窗口滑动算法，首先统计模式串所有字符出现的次数，并定义一个count用来保存当前已经匹配到的异位词数量。
     * 然后开始移动窗口，统计当前字符串的字符数量，如果当前字符在模式串有出现，并且当前字符在窗口出现的次数小于模式串的次数，那么count+1.
     * 如果count与模式串的长度相等，说明已经找到异位词，当前left的索引位就是异位词的起始位。
     * 当窗口的长度等于模式串的长度时，就要开始收缩窗口，也就是移动左指针，同时需要判断要剔除的字符是否包含在count里，如果包含就count数量-1,
     * 当当前字符在的数量大于模式串对应的字符数量时，只需要剔除就行，不需要操作count。
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0, len = p.length(),end = s.length();
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for (char c : p.toCharArray())
            pFreq[c - 'a']++;

        while (right < end) {
            char curChar = s.charAt(right);
            sFreq[curChar - 'a']++;

            if (pFreq[curChar - 'a'] > 0 && sFreq[curChar - 'a'] <= pFreq[curChar - 'a'])
                count++;

            if (count == len)
                ans.add(left);

            if (right - left + 1 >= len) {
                char leftChar = s.charAt(left);
                if (pFreq[leftChar - 'a'] > 0 && sFreq[leftChar - 'a'] <= pFreq[leftChar - 'a'])
                    count--;

                sFreq[leftChar - 'a']--;
                left++;
            }
            right++;
        }

        return ans;
    }


    public static void main(String[] args) {
        _438_Find_All_Anagrams_in_a_String test = new _438_Find_All_Anagrams_in_a_String();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
        System.out.println(test.findAnagrams("abab", "ab"));
        System.out.println(test.findAnagrams("aabbbbb", "ab"));
    }
}
