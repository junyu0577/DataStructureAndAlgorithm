package com.github.junyu.solution.easy.string;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/18 17:14
 */
public class _008_Implement_strStr {

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

//    /**
//     * 暴力求解.. 按顺序挨个对比字符串,效率低下
//     * @param haystack
//     * @param needle
//     * @return
//     */
//    public static int strStr(String haystack, String needle) {
//        if (needle == null || "".equals(needle))
//            return 0;
//        if (needle.length() > haystack.length())
//            return -1;
//        int count;
//        for (int i = 0; i < haystack.length(); i++) {
//            count = 0;
//            for (int j = 0; j < needle.length() && j + i < haystack.length(); j++) {
//                if (haystack.charAt(i + j) == needle.charAt(j)) {
//                    count++;
//                    if (count == needle.length())
//                        return i;
//                } else {
//                    break;
//                }
//            }
//        }
//        return -1;
//    }

    /**
     * KMP算法
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
        //TODO
        return -1;
    }

    public static void main(String[] args) {
//        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "aaaab", needle = "b";
//        String haystack = "mississippi", needle = "issipi";
//        String haystack = "bbaa", needle = "aab";
        String haystack = "mississippi", needle = "issip";

        System.out.println(strStr(haystack, needle));
    }
}
