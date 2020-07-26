package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1078_Occurrences_After_Bigram {

   /* Given words first and second, consider occurrences in some text of the form "first second third",
    where second comes immediately after first, and third comes immediately after second.

    For each such occurrence, add "third" to the answer, and return the answer.



    Example 1:

    Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
    Output: ["girl","student"]
    Example 2:

    Input: text = "we will we will rock you", first = "we", second = "will"
    Output: ["we","rock"]


    Note:

            1 <= text.length <= 1000
    text consists of space separated words, where each word consists of lowercase English letters.
    1 <= first.length, second.length <= 10
    first and second consist of lowercase English letters.*/

    /**
     * Bigram 分词(找出紧随first second 的那些单词)
     * 思路：比较当前以及下一个元素是否分别和first second相同，如果相同则将i+2的元素插入到结果数据。
     * 同时下次的比较的起始位置为i+2。
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String [] words = text.split(" ");
        for (int i=0;i<words.length-2;i++) {
            if (words[i].equals(first) && words[i+1].equals(second)){
                ans.add(words[i+2]);
                i++;
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        _1078_Occurrences_After_Bigram test = new _1078_Occurrences_After_Bigram();
        System.out.println(Arrays.toString(test.findOcurrences("alice is a good girl she is a good student", "a",
                "good")));
        System.out.println(Arrays.toString(test.findOcurrences("we will we will rock you", "we", "will")));
        System.out.println(Arrays.toString(test.findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa " +
                "jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa", "kcyxdfnoa", "jkypmsxd")));
    }
}
