package com.github.junyu.solution.leetCode.medium.string;

public class _005_Longest_Palindromic_Substring {

  /*  Given a string s, find the longest palindromic substring in s.
    You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
            Example 2:

    Input: "cbbd"
    Output: "bb"*/


    private int start, maxLen;

    /**
     * 求最长回文子串
     * 暴力遍历字符串两轮也就是0（n^2）的时间复杂度，
     * 以当前遍历的到字符为圆心，向左右两边进行匹配，如果左边的元素和右边的元素相同，继续向两边扩散。
     * 直接不匹配时，进行maxLen的判断，通过right-left-1得出当前最长回文的长度，如果比上一次记录的大，就更新
     * maxLen的值，和start的值，因为事件对left进行了-1操作，所以需要将start的起始位置更正在正确的起始位置。
     * 由于回文串存在奇偶两种情况，所以仅仅利用某一个点开始向两边扩散的判断是不够的，故又多一轮从i和i+1的位置开始的扩散。
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s.length() < 2)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }

        return s.substring(start,start+maxLen);

    }

    private void checkPalindrome(String s, int left, int right) {
        while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (maxLen < right - left - 1) {
            maxLen = right - left - 1;
            start = left + 1;
        }
    }


    public static void main(String[] args) {
        _005_Longest_Palindromic_Substring longest_palindromic_substring = new _005_Longest_Palindromic_Substring();
//        System.out.println(longest_palindromic_substring.longestPalindrome("abba"));
//        System.out.println(longest_palindromic_substring.longestPalindrome("aba"));
        System.out.println(longest_palindromic_substring.longestPalindrome("abcc"));
    }

}
