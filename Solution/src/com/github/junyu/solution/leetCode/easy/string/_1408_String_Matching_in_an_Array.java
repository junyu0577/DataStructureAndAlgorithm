package com.github.junyu.solution.leetCode.easy.string;

import java.util.*;

public class _1408_String_Matching_in_an_Array {

   /* Given an array of string words. Return all strings in words which is substring of another word in any order.

    String words[i] is substring of words[j], if can be obtained removing some characters
     to left and/or right side of words[j].

    Example 1:

    Input: words = ["mass","as","hero","superhero"]
    Output: ["as","hero"]
    Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
            ["hero","as"] is also a valid answer.

    Example 2:

    Input: words = ["leetcode","et","code"]
    Output: ["et","code"]
    Explanation: "et", "code" are substring of "leetcode".

    Example 3:

    Input: words = ["blue","green","bu"]
    Output: []


    Constraints:

            1 <= words.length <= 100
            1 <= words[i].length <= 30
    words[i] contains only lowercase English letters.
            It's guaranteed that words[i] will be unique.*/

    /**
     * 找到数组中其他字符串的所有子串
     * 通过两两比较查看两个字符串之间是否有包含关系，如果有就加入set集合中，由于我没有提前对数组的元素按字符长度进行排序，
     * 所以在遍历时需要查看两个元素之间是谁包含了谁。
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].contains(words[j])) {
                    ans.add(words[j]);
                } else if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        _1408_String_Matching_in_an_Array test = new _1408_String_Matching_in_an_Array();
        System.out.println(test.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(test.stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(test.stringMatching(new String[]{"blue", "green", "bu"}));
    }
}
