package com.github.junyu.solution.leetCode.medium.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _003_Longest_Substring_Without_Repeating_Characters {

/*
    Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer
    must be a substring, "pwke" is a subsequence and not a substring.*/


    /**
     * 求不同字母组成的最大子串长
     * 定义一个集合，用于存放不同的字符
     * 从第一个元素开始遍历，依次后后面的元素进行比较，如果集合中已经含有就跳出循环，然后比较count和集合的长度，如果
     * 集合长度大于count就更新count的值。再从第二个元素开始于后续的元素进行比较。。
     * 时间复杂度为o(n^2)
     *
     * @param s
     * @return
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0)
//            return 0;
//
//        List<Character> list = new ArrayList<>();
//        int count = 0;
//        char cs[] = s.toCharArray();
//        for (int i = 0; i + count < cs.length; i++) {
//            list.add(cs[i]);
//            for (int j = i + 1; j < cs.length; j++) {
//                if (list.contains(cs[j])) {
//                    break;
//                } else {
//                    list.add(cs[j]);
//                }
//            }
//            count = Math.max(count, list.size());
//            list.clear();
//        }
//        return count;
//    }

    /**
     * 通过设置快慢指针，快指针不断的往下遍历，如果下一个元素不在hashset中，就add进来，接着更新count的值，然后继续匹配下一个。
     * 如果已经在hashset中，就删除慢指针指向的元素，也就是头部，然后慢指针往右移。然后继续hashset的contain判断。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int slow = 0, fast = 0, count = 0;
        HashSet<Character> set = new HashSet();
        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast));
                fast++;
                count = Math.max(count, set.size());
            } else {
                set.remove(s.charAt(slow));
                slow++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        _003_Longest_Substring_Without_Repeating_Characters longest_substring_without_repeating_characters = new _003_Longest_Substring_Without_Repeating_Characters();
//        System.out.println(longest_substring_without_repeating_characters.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(longest_substring_without_repeating_characters.lengthOfLongestSubstring("bba"));
//        System.out.println(longest_substring_without_repeating_characters.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longest_substring_without_repeating_characters.lengthOfLongestSubstring("abcabcbb"));
    }

}
