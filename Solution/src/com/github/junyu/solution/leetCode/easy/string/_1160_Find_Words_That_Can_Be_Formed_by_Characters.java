package com.github.junyu.solution.leetCode.easy.string;

import java.util.Arrays;

public class _1160_Find_Words_That_Can_Be_Formed_by_Characters {

    /*You are given an array of strings words and a string chars.

    A string is good if it can be formed by characters from chars
            (each character can only be used once).

    Return the sum of lengths of all good strings in words.

    Example 1:

    Input: words = ["cat","bt","hat","tree"], chars = "atach"
    Output: 6
    Explanation:
    The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
    Example 2:

    Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
    Output: 10
    Explanation:
    The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.


    Note:

            1 <= words.length <= 1000
            1 <= words[i].length, chars.length <= 100
    All strings contain lowercase English letters only.*/


    /**
     * 思路:统计chars的字符出现次数，然后在循环单词数组时，针对每个单词都单词拷贝一份count数组，遍历单词
     * 的字符，对拷贝的数组进行数量减少操作，一旦发现拷贝的数组出现小于0的元素，如果出现了一个不存在的单词。
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            int[] tempArr = Arrays.copyOf(count, count.length);
            char[] cs = words[i].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                tempArr[cs[j] - 'a']--;
                if (tempArr[cs[j] - 'a'] < 0)
                    break;

                if (j == cs.length - 1)
                    sum += words[i].length();
            }
        }
        return sum;
    }

//    /**
//     * 判断单词是否由chars字符组成，返回符合条件的单词总长度
//     * 思路:统计chars的字符出现次数，然后再依次统计words中每个单词各自字符出现的次数，
//     * 最后判断只要words中的单词的字符出现的次数多于chars中所出现的则不满足条件。
//     * @param words
//     * @param chars
//     * @return
//     */
//    public int countCharacters(String[] words, String chars) {
//        int[] count = new int[26];
//        for (char c : chars.toCharArray()) {
//            count[c - 'a']++;
//        }
//
//        int sum = 0;
//        for (int i = 0; i < words.length; i++) {
//            char[] cs = words[i].toCharArray();
//            char[] wordsCount = new char[26];
//            for (char c : cs) {
//                wordsCount[c - 'a']++;
//            }
//
//            for (int j = 0; j < wordsCount.length; j++) {
//                if (wordsCount[j] > count[j])
//                    break;
//                if (j == wordsCount.length-1)
//                    sum += words[i].length();
//            }
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        _1160_Find_Words_That_Can_Be_Formed_by_Characters test = new _1160_Find_Words_That_Can_Be_Formed_by_Characters();
        System.out.println(test.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(test.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
