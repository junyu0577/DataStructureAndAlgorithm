package com.github.junyu.solution.leetCode.easy.string;

/**
 * @author ShaoJunyu
 * @since 2018/6/14 09:18
 */
public class _014_Longest_Common_Prefix {

  /*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"

    Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Note:

    All given inputs are in lowercase letters a-z.
    */

    /**
     * 思路：利用string的indexOf方法，当a的内容包含在b中时，会返回所在位置的索引，如果不包含则返回-1。
     * 因为是找出相同的前缀，所以只有两种情况，要么没有共同的内容导致prefix为""后跳出循环,或者是有共同内容，再进行下一个字符串的比较
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
            i++;
        }
        return prefix;
    }

    public static void main(String[] args) {
        String arr[] = new String[]{"flower", "flow", "flight"};
//        String arr[] = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(arr));
    }
}
