package com.github.junyu.solution.leetCode.easy.string;

public class _521_Longest_Uncommon_Subsequence_I {

    /*Given two strings, you need to find the longest uncommon subsequence of this two strings.
     The longest uncommon subsequence is defined as the longest subsequence of one of these strings and
     this subsequence should not be any subsequence of the other string.

    A subsequence is a sequence that can be derived from one sequence by deleting some characters
    without changing the order of the remaining elements. Trivially, any string is a subsequence of itself
    and an empty string is a subsequence of any string.

    The input will be two strings, and the output needs to be the length of the longest uncommon subsequence.
    If the longest uncommon subsequence doesn't exist, return -1.

    Example 1:

    Input: a = "aba", b = "cdc"
    Output: 3
    Explanation: The longest uncommon subsequence is "aba",
    because "aba" is a subsequence of "aba",
    but not a subsequence of the other string "cdc".
    Note that "cdc" can be also a longest uncommon subsequence.
            Example 2:

    Input: a = "aaa", b = "bbb"
    Output: 3
    Example 3:

    Input: a = "aaa", b = "aaa"
    Output: -1


    Constraints:

    Both strings' lengths will be between [1 - 100].
    Only letters from a ~ z will appear in input strings.*/

    /**
     * 最长特殊序列 定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
     * 思路：如果两个字符串内容相等，那么不同子序列的长度就是-1.不相同的时候，长的一方的肯定就是最长的特殊序列。
     *
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(),b.length());
    }

    public static void main(String [] args) {
        _521_Longest_Uncommon_Subsequence_I test = new _521_Longest_Uncommon_Subsequence_I();
        System.out.println(test.findLUSlength("aba","cdc"));
        System.out.println(test.findLUSlength("aaa","bbb"));
        System.out.println(test.findLUSlength("aaa","aaa"));
    }
}
