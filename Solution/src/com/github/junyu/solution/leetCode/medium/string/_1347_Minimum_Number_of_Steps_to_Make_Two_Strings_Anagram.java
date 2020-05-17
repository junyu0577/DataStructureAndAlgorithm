package com.github.junyu.solution.leetCode.medium.string;

public class _1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {

    /*Given two equal-size strings s and t. In one step you can choose any character of t and replace
    it with another character.

    Return the minimum number of steps to make t an anagram of s.

    An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

    Example 1:

    Input: s = "bab", t = "aba"
    Output: 1
    Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
            Example 2:

    Input: s = "leetcode", t = "practice"
    Output: 5
    Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
            Example 3:

    Input: s = "anagram", t = "mangaar"
    Output: 0
    Explanation: "anagram" and "mangaar" are anagrams.
    Example 4:

    Input: s = "xxyyzz", t = "xxyyzz"
    Output: 0
    Example 5:

    Input: s = "friend", t = "family"
    Output: 4


    Constraints:

            1 <= s.length <= 50000
    s.length == t.length
    s and t contain lower-case English letters only.*/

    /**
     * 替换t字符串的字符，使得s和t成为异位词，求最小的替换次数
     * 先统计两个字符串的各个字符的出现次数。然后统计t字符多出的和不足的字符数量。
     * 如果多出的字符和不足的字符持平，那么这个数量就是需要被替换的次数。
     * 如果不相等那么他们之间的差的绝对值就是替换的次数。
     * @param s
     * @param t
     * @return
     */
    public int minSteps(String s, String t) {
        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];
        for (char c : s.toCharArray()) {
            sCharCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tCharCount[c - 'a']++;
        }

        int addCount = 0;
        int removeCount = 0;
        for (int i = 0; i < sCharCount.length; i++) {
            int result = sCharCount[i] - tCharCount[i];
            if (result > 0) {
                addCount += result;
            } else if (result < 0) {
                removeCount += Math.abs(result);
            }
        }
        return addCount == removeCount ? addCount : Math.abs(addCount - removeCount);
    }

    public static void main(String[] args) {
        _1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram test =
                new _1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram();
        System.out.println(test.minSteps("bab", "aba"));
        System.out.println(test.minSteps("leetcode", "practice"));
        System.out.println(test.minSteps("anagram", "mangaar"));
        System.out.println(test.minSteps("xxyyzz", "xxyyzz"));
        System.out.println(test.minSteps("friend", "family"));
    }
}
