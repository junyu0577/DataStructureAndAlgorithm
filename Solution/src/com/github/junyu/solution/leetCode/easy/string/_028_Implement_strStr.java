package com.github.junyu.solution.leetCode.easy.string;


/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/18 17:14
 */
public class _028_Implement_strStr {

  /*
    Implement strStr().

    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string.
    This is consistent to C's strstr() and Java's indexOf().
    */

    /**
     * Brute Force算法
     * 先比较h和n的第一个字符，如果相同就比较两则的第二个字符，相等就继续，直接结束。
     * 如果某一个元素不相等，那么再从h的下一个字符开始继续和n进行从头逐到尾逐一比较
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle))
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == needle.length() - 1)
                        return i;
                } else {
                    break;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "aaaab", needle = "b";
//        String haystack = "mississippi", needle = "issipi";
//        String haystack = "bbaa", needle = "aab";
//        String haystack = "mississippi", needle = "issip";

        System.out.println(strStr(haystack, needle));
    }
}
