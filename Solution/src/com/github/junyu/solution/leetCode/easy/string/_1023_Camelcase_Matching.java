package com.github.junyu.solution.leetCode.easy.string;

import java.util.ArrayList;
import java.util.List;

public class _1023_Camelcase_Matching {

/*
    A query word matches a given pattern if we can insert lowercase letters to the pattern word
    so that it equals the query. (We may insert each character at any position, and may insert 0
    characters.)

    Given a list of queries, and a pattern, return an answer list of booleans, where answer[i]
    is true if and only if queries[i] matches the pattern.



    Example 1:

    Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
    Output: [true,false,true,true,false]
    Explanation:
            "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
            "FootBall" can be generated like this "F" + "oot" + "B" + "all".
            "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
    Example 2:

    Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
    Output: [true,false,true,false,false]
    Explanation:
            "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
            "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
    Example 3:

    Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
    Output: [false,true,false,false,false]
    Explanation:
            "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".


    Note:

            1 <= queries.length <= 100
            1 <= queries[i].length <= 100
            1 <= pattern.length <= 100
    All strings consists only of lower and upper case English letters.

    */

    /**
     * 驼峰匹配，允许字符串出现模式串所出现的字符，并且在大写字符以后可以跟随任意字符（但是如果模式串的大写字符后面页
     * 跟随了小写字符，那么字符串也必须与之匹配）
     * 利用双指针，一个指针指i向数组中当前字符串的字符，另一个指针p指向模式串的字符。
     * 如果两个指针当前指向的元素相同，那么两个指针都向后同时移动。
     * 如果两个指针指向的不同，则要查看i指针所指的元素是否是大写字符，如果是则匹配失败。
     * 最后，当两个指针都指向了各自的最后元素，表面是匹配成功的。
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        for (String str : queries) {
            ans.add(isMatch(str.toCharArray(), pattern));
        }
        return ans;
    }

    private boolean isMatch(char[] chars, String pattern) {
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            if (p < pattern.length() && chars[i] == pattern.charAt(p))
                p++;
            else if (isUpperCase(chars[i]))
                return false;

        }

        return p == pattern.length();
    }

    private boolean isUpperCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _1023_Camelcase_Matching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"));
        System.out.println(new _1023_Camelcase_Matching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa"));
        System.out.println(new _1023_Camelcase_Matching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT"));
    }
}
