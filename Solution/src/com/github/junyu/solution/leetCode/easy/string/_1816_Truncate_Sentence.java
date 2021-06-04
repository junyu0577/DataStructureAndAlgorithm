package com.github.junyu.solution.leetCode.easy.string;

public class _1816_Truncate_Sentence {

/*
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    Each of the words consists of only uppercase and lowercase English letters (no punctuation).

    For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
    You are given a sentence s​​​​​​ and an integer k​​​​​​. You want to truncate s​​​​​​
    such that it contains only the first k​​​​​​ words. Return s​​​​​​ after truncating it.

    Example 1:

    Input: s = "Hello how are you Contestant", k = 4
    Output: "Hello how are you"
    Explanation:
    The words in s are ["Hello", "how" "are", "you", "Contestant"].
    The first 4 words are ["Hello", "how", "are", "you"].
    Hence, you should return "Hello how are you".
    Example 2:

    Input: s = "What is the solution to this problem", k = 4
    Output: "What is the solution"
    Explanation:
    The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
    The first 4 words are ["What", "is", "the", "solution"].
    Hence, you should return "What is the solution".
    Example 3:

    Input: s = "chopper is not a tanuki", k = 5
    Output: "chopper is not a tanuki"


    Constraints:

            1 <= s.length <= 500
    k is in the range [1, the number of words in s].
    s consist of only lowercase and uppercase English letters and spaces.
    The words in s are separated by a single space.
    There are no leading or trailing spaces.
    */

    /**
     * 截断句子
     * 将字符串按"空格"切割开，然后提取前k个元素组成新的字符串。
     *
     * Runtime: 1 ms, faster than 72.42% of Java online submissions for Truncate Sentence.
     * Memory Usage: 37.4 MB, less than 68.54% of Java online submissions for Truncate Sentence.
     *
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        String [] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<k;i++){
            sb.append(arr[i]+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        _1816_Truncate_Sentence test = new _1816_Truncate_Sentence();
        System.out.println(test.truncateSentence("Hello how are you Contestant", 4));
        System.out.println(test.truncateSentence("What is the solution to this problem", 4));
        System.out.println(test.truncateSentence("chopper is not a tanuki", 5));
    }

}
