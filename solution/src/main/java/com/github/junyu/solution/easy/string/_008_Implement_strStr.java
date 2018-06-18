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


    public static int strStr(String haystack, String needle) {
        //TODO
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
//        String haystack = "hello", needle = "ll";
        String haystack = "aaaaa", needle = "bba";
        System.out.println(strStr(haystack, needle));
    }
}
