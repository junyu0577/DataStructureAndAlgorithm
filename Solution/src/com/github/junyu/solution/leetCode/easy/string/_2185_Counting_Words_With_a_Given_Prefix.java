package com.github.junyu.solution.leetCode.easy.string;


public class _2185_Counting_Words_With_a_Given_Prefix {

    /*
    You are given an array of strings words and a string pref.

    Return the number of strings in words that contain pref as a prefix.

    A prefix of a string s is any leading contiguous substring of s.



            Example 1:

    Input: words = ["pay","attention","practice","attend"], pref = "at"
    Output: 2
    Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
    Example 2:

    Input: words = ["leetcode","win","loops","success"], pref = "code"
    Output: 0
    Explanation: There are no strings that contain "code" as a prefix.


            Constraints:

            1 <= words.length <= 100
            1 <= words[i].length, pref.length <= 100
    words[i] and pref consist of lowercase English letters.
    */


    /**
     * 统计符合字符串前缀的单词个数
     *
     * 遍历数组用字符串的startsWith方法去判断是否是前缀
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Counting Words With a Given Prefix.
     * Memory Usage: 41.9 MB, less than 97.24% of Java online submissions for Counting Words With a Given Prefix.
     *
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String str :words){
            if (str.startsWith(pref))
                ans++;
        }
        return ans;
    }
    
    public static void main(String [] args) {
        _2185_Counting_Words_With_a_Given_Prefix test = new _2185_Counting_Words_With_a_Given_Prefix();
        System.out.println(test.prefixCount(new String[]{"pay","attention","practice","attend"},"at"));
        System.out.println(test.prefixCount(new String[]{"leetcode","win","loops","success"},"code"));
    }
    
}
