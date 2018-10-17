package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.Arrays;

public class _748_Shortest_Completing_Word {

  /*  Find the minimum length word from a given dictionary words, which has all the
    letters from the string licensePlate. Such a word is said to complete the given string licensePlate

    Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

    It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

    The license plate might have the same letter occurring multiple times. For example,
    given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

            Example 1:
    Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
    Output: "steps"
    Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
    Note that the answer is not "step", because the letter "s" must occur in the word twice.
    Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
            Example 2:
    Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
    Output: "pest"
    Explanation: There are 3 smallest length words that contains the letters "s".
    We return the one that occurred first.
            Note:
    licensePlate will be a string with length in range [1, 7].
    licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
    words will have a length in the range [10, 1000].
    Every words[i] will consist of lowercase letters, and have length in range [1, 15].*/

    /**
     * 找到可以匹配的最短完整单词
     * 先统计出licensePlate中出现的字母的次数，存入哈希表中。
     * 遍历words数据，针对里面的每个字符串，他们的出现次数减掉hash表中的对应元素。最后遍历hash表时，如果
     * hash表所有的元素都小于等于0，那么说明整个字符串是匹配的，记下长度，如果长度小于maxLen，那么则更新res，最后
     * 返回res。
     *
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int letters[] = new int[26];
        for (char c : licensePlate.toCharArray()) {
            c = Character.toLowerCase(c);
            if (Character.isLetter(c)) {
                letters[c - 'a']++;
            }
        }

        String res = null;
        int maxLen = Integer.MAX_VALUE;

        for (String s : words) {
            int copyLetters[] = Arrays.copyOf(letters, letters.length);
            for (char c : s.toCharArray()) {
                copyLetters[c - 'a']--;
            }

            for (int i = 0; i < copyLetters.length; i++) {
                if (copyLetters[i] > 0) {
                    break;
                }
                if (i == copyLetters.length - 1) {
                    if (s.length() < maxLen) {
                        maxLen = s.length();
                        res = s;
                    }
                }

            }
        }

        return res;

    }


    public static void main(String[] args) {
        _748_Shortest_Completing_Word shortest_completing_word = new _748_Shortest_Completing_Word();
        System.out.println(shortest_completing_word.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(shortest_completing_word.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
