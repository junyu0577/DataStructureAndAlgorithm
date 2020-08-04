package com.github.junyu.solution.interview.easy;

public class _0102 {

    /*给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

    示例 1：

    输入: s1 = "abc", s2 = "bca"
    输出: true
    示例 2：

    输入: s1 = "abc", s2 = "bad"
    输出: false
    说明：

            0 <= len(s1) <= 100
            0 <= len(s2) <= 100*/

    /**
     * 确定其中一个字符串的字符重新排列后，能否变成另一个字符串
     * 思路：统计s1出现的次数，然后再减去s2中出现的字符次数。如果两个字符串元素相等，那么最后count中所有的字符出现次数应该都为0.
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        int [] count  = new int[26];
        for (char c : s1.toCharArray())
            count[c-'a']++;

        for (char c : s2.toCharArray())
            count[c-'a']--;

        for (int i: count){
            if (i!=0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        _0102 test = new _0102();
        System.out.println(test.CheckPermutation("abc","bca"));
        System.out.println(test.CheckPermutation("abc","bad"));
    }
}
