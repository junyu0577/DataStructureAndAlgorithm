package com.github.junyu.solution.leetCode.easy.string;

public class _1832_Check_if_the_Sentence_Is_Pangram {

    /*
    A pangram is a sentence where every letter of the English alphabet appears at least once.

    Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false
     otherwise.

    Example 1:

    Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
    Output: true
    Explanation: sentence contains at least one of every letter of the English alphabet.


    Example 2:

    Input: sentence = "leetcode"
    Output: false


    Constraints:

            1 <= sentence.length <= 1000
    sentence consists of lowercase English letters.
    */

    /**
     * 判断句子是否为全字母句
     *
     * 建立hash表统计字母出现的次数，然后遍历hash表当发现为0的值时，说明不是全字母句子。
     *
     * Runtime: 1 ms, faster than 91.45% of Java online submissions for Check if the Sentence Is Pangram.
     * Memory Usage: 36.7 MB, less than 97.09% of Java online submissions for Check if the Sentence Is Pangram.
     *
     * @param sentence
     * @return
     */
    public boolean checkIfPangram(String sentence) {
        int[] hash = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            hash[sentence.charAt(i) - 'a']++;
        }
        for (int i : hash) {
            if (i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _1832_Check_if_the_Sentence_Is_Pangram test = new _1832_Check_if_the_Sentence_Is_Pangram();
        System.out.println(test.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(test.checkIfPangram("leetcode"));
    }
}
