package com.github.junyu.solution.leetCode.easy.string;

public class _1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {

    /*
    You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string
            (not necessarily different) and swap the characters at these indices.

    Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings.
        Otherwise, return false.

    Example 1:

    Input: s1 = "bank", s2 = "kanb"
    Output: true
    Explanation: For example, swap the first character with the last character of s2 to make "bank".
    Example 2:

    Input: s1 = "attack", s2 = "defend"
    Output: false
    Explanation: It is impossible to make them equal with one string swap.
            Example 3:

    Input: s1 = "kelb", s2 = "kelb"
    Output: true
    Explanation: The two strings are already equal, so no string swap operation is required.
    Example 4:

    Input: s1 = "abcd", s2 = "dcba"
    Output: false


    Constraints:

            1 <= s1.length, s2.length <= 100
    s1.length == s2.length
    s1 and s2 consist of only lowercase English letters.
        */

    /**
     * 仅执行一次字符串交换能否使两个字符串相等
     *
     * 通过遍历数组找出同索引，字符不同的数量,同时收集所有字符出现的次数。然后遍历hash表查看两个字符串所有的元素出现的次数是否都相同，如果有次数不同的，
     * 则无法满足题意。最后根据不同字符出现的次数，只要count为0或者为2就满足题意。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if One String Swap Can Make Strings Equal.
     * Memory Usage: 37.3 MB, less than 37.62% of Java online submissions for Check if One String Swap Can Make Strings Equal.
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int [] hashA = new int[26];
        int [] hashB = new int[26];
        for (int i=0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1!=c2)
                count++;

            hashA[c1-'a']++;
            hashB[c2-'a']++;
        }

        for (int i=0;i<hashA.length;i++){
            if (hashA[i]!=hashB[i])
                return false;
        }

        return count==2 || count==0;
    }

    public static void main(String[] args) {
        _1790_Check_if_One_String_Swap_Can_Make_Strings_Equal test = new _1790_Check_if_One_String_Swap_Can_Make_Strings_Equal();
        System.out.println(test.areAlmostEqual("bank", "kanb"));
        System.out.println(test.areAlmostEqual("attack", "defend"));
        System.out.println(test.areAlmostEqual("kelb", "kelb"));
        System.out.println(test.areAlmostEqual("abcd", "dcba"));
        System.out.println(test.areAlmostEqual("caa", "aaz"));


    }
}
