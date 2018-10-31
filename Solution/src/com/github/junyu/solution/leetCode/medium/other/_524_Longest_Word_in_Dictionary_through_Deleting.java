package com.github.junyu.solution.leetCode.medium.other;

import java.util.Arrays;
import java.util.List;

public class _524_Longest_Word_in_Dictionary_through_Deleting {

  /*  Given a string and a string dictionary, find the longest string in the
    dictionary that can be formed by deleting some characters of the given string.
    If there are more than one possible results, return the longest word
    with the smallest lexicographical order. If there is no possible result, return the empty string.

            Example 1:
    Input:
    s = "abpcplea", d = ["ale","apple","monkey","plea"]

    Output:
            "apple"
    Example 2:
    Input:
    s = "abpcplea", d = ["a","b","c"]

    Output:
            "a"
    Note:
    All the strings in the input will only contain lower-case letters.
    The size of the dictionary won't exceed 1,000.
    The length of all the strings in the input won't exceed 1,000.*/

    /**
     * 删除s中部分字符，与d中元素相等。返回d长度最长的元素，如果两个元素的长度相等则返回字典序靠前的。
     * 遍历d集合，针对每个元素，再单独与s进行比较，定义两个指针分别指向s和元素的末尾，然后从尾部进行两则的比较。
     * 如果字符相等，则两个指针都需要--，不相等那么只需要维护s串的指针--。
     * 当其中一个指针小于0，我们需要判断指向元素的指针是否已经小于0，小于0则说明已经匹配上了。然后再和定义最大长度进行比较，
     * 如果当前元素的长度大于len，那么更新len以及结果字符串res。如果长度相等，那么近一步再比较字典序，如果小于上一个字符串，更新。
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {

        String res = "";
        int len = 0;
        char strArr[] = s.toCharArray();
        for (int i = 0; i < d.size(); i++) {
            int p1 = s.length() - 1;
            int p2 = d.get(i).length() - 1;

            char wordsArr []  = d.get(i).toCharArray();

            while (p1 >= 0 && p2 >= 0) {
                if (strArr[p1] == wordsArr[p2]) {
                    p2--;
                }
                p1--;
            }

            if (p2 < 0) {
                if (d.get(i).length() > len) {
                    len = d.get(i).length();
                    res = d.get(i);
                } else if (d.get(i).length() == len) {
                    if (res.compareTo(d.get(i)) > 0)
                        res = d.get(i);
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        _524_Longest_Word_in_Dictionary_through_Deleting longest_word_in_dictionary_through_deleting = new _524_Longest_Word_in_Dictionary_through_Deleting();
        System.out.println(longest_word_in_dictionary_through_deleting.findLongestWord("abpcplea", Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"})));
        System.out.println(longest_word_in_dictionary_through_deleting.findLongestWord("abpcplea", Arrays.asList(new String[]{"a", "b", "c"})));
        System.out.println(longest_word_in_dictionary_through_deleting.findLongestWord("bab", Arrays.asList(new String[]{"ba", "ab", "a", "b"})));
    }

}
