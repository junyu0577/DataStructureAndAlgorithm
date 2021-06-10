package com.github.junyu.solution.leetCode.easy.string;

public class _1768_Merge_Strings_Alternately {

    /*
    You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting
    with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

    Return the merged string.

    Example 1:

    Input: word1 = "abc", word2 = "pqr"
    Output: "apbqcr"
    Explanation: The merged string will be merged as so:
    word1:  a   b   c
    word2:    p   q   r
    merged: a p b q c r
    Example 2:

    Input: word1 = "ab", word2 = "pqrs"
    Output: "apbqrs"
    Explanation: Notice that as word2 is longer, "rs" is appended to the end.
            word1:  a   b
    word2:    p   q   r   s
    merged: a p b q   r   s
    Example 3:

    Input: word1 = "abcd", word2 = "pq"
    Output: "apbqcd"
    Explanation: Notice that as word1 is longer, "cd" is appended to the end.
            word1:  a   b   c   d
    word2:    p   q
    merged: a p b q c   d


    Constraints:

            1 <= word1.length, word2.length <= 100
    word1 and word2 consist of lowercase English letters.
    */

    /**
     * 交替合并字符串
     * 由于字符串的长度不一，所以要先在同一长度的情况下进行穿插取值，获取长度最小值，先往ans数组中进行穿插写入。
     * 然后剩下的就是从较长的字符串中取出剩余部分元素依次写入数组。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Strings Alternately.
     * Memory Usage: 37.3 MB, less than 74.93% of Java online submissions for Merge Strings Alternately.
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1,len2);

        char [] ans = new char[len1+len2];
        int count = 0;
        int index = 0;
        while (count<minLen){
            ans[index] = word1.charAt(count) ;
            count++;
                index+=2;
        }
        count = 0;
        index = 1;
        while (count<minLen){
            ans[index] = word2.charAt(count) ;
            count++;
            index+=2;
        }

        if (len1>minLen){
            for (int i=minLen*2;i<ans.length;i++){
                ans[i] = word1.charAt(minLen++);
            }
        }else if (len2>minLen){
            for (int i=minLen*2;i<ans.length;i++){
                ans[i] = word2.charAt(minLen++);
            }
        }

        return new String(ans);
    }


    public static void main(String[] args) {
        _1768_Merge_Strings_Alternately test = new _1768_Merge_Strings_Alternately();
        System.out.println(test.mergeAlternately("abc", "pqr"));
        System.out.println(test.mergeAlternately("ab", "pqrs"));
        System.out.println(test.mergeAlternately("abcd", "pq"));
        System.out.println(test.mergeAlternately("cdf", "a"));
    }

}
