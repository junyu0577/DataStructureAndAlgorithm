package com.github.junyu.solution.leetCode.easy.string;

public class _1876_Substrings_of_Size_Three_with_Distinct_Characters {

 /*
    A string is good if there are no repeated characters.

    Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

    Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

    A substring is a contiguous sequence of characters in a string.

    Example 1:

    Input: s = "xyzzaz"
    Output: 1
    Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
    The only good substring of length 3 is "xyz".
    Example 2:

    Input: s = "aababcabc"
    Output: 4
    Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
    The good substrings are "abc", "bca", "cab", and "abc".


    Constraints:

            1 <= s.length <= 100
    s​​​​​​ consists of lowercase English letters.
    */

    /**
     * 长度为三且各字符不同的子字符串的数量
     * 依次提取三位进行比较
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Substrings of Size Three with Distinct Characters.
     * Memory Usage: 37.1 MB, less than 92.16% of Java online submissions for Substrings of Size Three with Distinct Characters.
     * @param s
     * @return
     */
    public int countGoodSubstrings(String s) {
        int ans = 0;
        for (int i=0;i<s.length()-2;i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2);
            if (a!=b && b!=c && a!=c)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1876_Substrings_of_Size_Three_with_Distinct_Characters test = new _1876_Substrings_of_Size_Three_with_Distinct_Characters();
        System.out.println(test.countGoodSubstrings("xyzzaz"));
        System.out.println(test.countGoodSubstrings("aababcabc"));
    }
}
