package com.github.junyu.solution.leetCode.easy.greedy;

public class _392_Is_Subsequence {

    /*Given a string s and a string t, check if s is subsequence of t.

    A subsequence of a string is a new string which is formed from the original string by deleting
    some (can be none) of the characters without disturbing the relative positions of the remaining
    characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

    Follow up:
    If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by
    one to see if T has its subsequence. In this scenario, how would you change your code?

    Credits:
    Special thanks to @pbrother for adding this problem and creating all test cases.

    Example 1:

    Input: s = "abc", t = "ahbgdc"
    Output: true
    Example 2:

    Input: s = "axc", t = "ahbgdc"
    Output: false

    Constraints:

            0 <= s.length <= 100
            0 <= t.length <= 10^4
    Both strings consists only of lowercase characters.*/

    /**
     * 判断子序列
     * 思路：定义两个指针分别指向s和t，从头开始进行比较，如果t和s的当前字符相同则两个指针同时移动，如果不同则移动t的指针。
     * 当指向s的指针left等于s的长度，s就是t的子序列。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        int left = 0;
        int right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                if (left == s.length())
                    return true;
            }
            right++;
        }
        return false;
    }


    public static void main(String[] args) {
        _392_Is_Subsequence test = new _392_Is_Subsequence();
//        System.out.println(test.isSubsequence("abc","ahbgdc"));
//        System.out.println(test.isSubsequence("axc", "ahbgdc"));
        System.out.println(test.isSubsequence("", "ahbgdc"));
    }
}
