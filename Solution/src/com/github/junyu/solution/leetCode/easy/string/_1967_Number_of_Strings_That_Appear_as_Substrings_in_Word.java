package com.github.junyu.solution.leetCode.easy.string;

public class _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {

    /*
    Given an array of strings patterns and a string word,
    return the number of strings in patterns that exist as a substring in word.

    A substring is a contiguous sequence of characters within a string.


    Example 1:

    Input: patterns = ["a","abc","bc","d"], word = "abc"
    Output: 3
    Explanation:
            - "a" appears as a substring in "abc".
            - "abc" appears as a substring in "abc".
            - "bc" appears as a substring in "abc".
            - "d" does not appear as a substring in "abc".
            3 of the strings in patterns appear as a substring in word.


    Example 2:

    Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
    Output: 2
    Explanation:
            - "a" appears as a substring in "aaaaabbbbb".
            - "b" appears as a substring in "aaaaabbbbb".
            - "c" does not appear as a substring in "aaaaabbbbb".
            2 of the strings in patterns appear as a substring in word.


    Example 3:

    Input: patterns = ["a","a","a"], word = "ab"
    Output: 3
    Explanation: Each of the patterns appears as a substring in word "ab".


    Constraints:

            1 <= patterns.length <= 100
            1 <= patterns[i].length <= 100
            1 <= word.length <= 100
    patterns[i] and word consist of lowercase English letters.
*/

    /**
     * 作为子字符串出现在单词中的字符串数目
     *
     * 用string的contains判断是否包含
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Strings That Appear as Substrings in Word.
     * Memory Usage: 39 MB, less than 67.95% of Java online submissions for Number of Strings That Appear as Substrings in Word.
     * @param patterns
     * @param word
     * @return
     */
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String pattern : patterns){
            if (word.contains(pattern))
                ans++;
        }
        return  ans;
    }

    public static void main(String [] args) {
        _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word test = new _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word();
        System.out.println(test.numOfStrings(new String[]{"a","abc","bc","d"},"abc"));
        System.out.println(test.numOfStrings(new String[]{"a","b","c"},"aaaaabbbbb"));
        System.out.println(test.numOfStrings(new String[]{"a","a","a"},"ab"));
    }
}
