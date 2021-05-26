package com.github.junyu.solution.leetCode.easy.string;

import java.util.Arrays;

public class _1624_Largest_Substring_Between_Two_Equal_Characters {

    /*
    Given a string s, return the length of the longest substring between two equal characters, excluding the two
    characters. If there is no such substring return -1.

    A substring is a contiguous sequence of characters within a string.

    Example 1:
    Input: s = "aa"
    Output: 0
    Explanation: The optimal substring here is an empty substring between the two 'a's.

    Example 2:
    Input: s = "abca"
    Output: 2
    Explanation: The optimal substring here is "bc".

    Example 3:
    Input: s = "cbzxy"
    Output: -1
    Explanation: There are no characters that appear twice in s.

    Example 4:
    Input: s = "cabbac"
    Output: 4
    Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".


    Constraints:

    1 <= s.length <= 300
    s contains only lowercase English letters.
    */

    /**
     * 两个相同字符之间的最长子字符串
     * 定义哈希表用以保存字符第一次出现得位置，当第二次出现时，求出当前位置与之前得位置得差值-1，然后与之前记录得最大字串长度进行比较更新。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Substring Between Two Equal Characters.
     * Memory Usage: 36.6 MB, less than 90.00% of Java online submissions for Largest Substring Between Two Equal Characters.
     *
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        char [] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int letterIndex = cs[i]-'a';
           if (pos[letterIndex]!=-1){
               ans = Math.max(ans,i-pos[letterIndex]-1);
           } else {
               pos[letterIndex] = i;
           }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1624_Largest_Substring_Between_Two_Equal_Characters test =
                new _1624_Largest_Substring_Between_Two_Equal_Characters();
        System.out.println(test.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(test.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(test.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(test.maxLengthBetweenEqualCharacters("cabbac"));
        System.out.println(test.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
    }
}
