package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1170_Compare_Strings_by_Frequency_of_the_Smallest_Character {

    /*Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character
    in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

    Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number
    of words such that f(queries[i]) < f(W), where W is a word in words.

    Example 1:

    Input: queries = ["cbd"], words = ["zaaaz"]
    Output: [1]
    Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
    Example 2:

    Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
    Output: [1,2]
    Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa")
    are both > f("cc").


    Constraints:

            1 <= queries.length <= 2000
            1 <= words.length <= 2000
            1 <= queries[i].length, words[i].length <= 10
    queries[i][j], words[i][j] are English lowercase letters.*/

    /**
     * 统计按字典序最小的字符出现的次数大于queries中相同条件的元素数量
     * 思路：先统计出words数组的所有元素的最小字符出现的字数，然后按升序进行排列，存放在count数组中。
     * 然后从queries数组取出元素，逐个获取最小字符出现的次数与比count数组进行比较，从count的末尾开始比较，遇到大于等于count的元素时，
     * count数组长度-1-当前count的索引的结果就是我们需要的结果。
     * @param queries
     * @param words
     * @return
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[words.length];
        int[] ans = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            count[i] = getLetterCount(words[i]);
        }

        Arrays.sort(count);

        for (int i = 0; i < queries.length; i++) {
            int len = count.length - 1;
            int index = len;
            int queryCount = getLetterCount(queries[i]);
            for (int j = index; j >= 0; j--) {
                if (count[j] <= queryCount)
                    break;
                index--;
            }
            ans[i] = len - index;
        }
        return ans;
    }

    private int getLetterCount(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return arr[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        _1170_Compare_Strings_by_Frequency_of_the_Smallest_Character test =
                new _1170_Compare_Strings_by_Frequency_of_the_Smallest_Character();
        System.out.println(Arrays.toString(test.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
        System.out.println(Arrays.toString(test.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a",
                "aa", "aaa", "aaaa"})));
    }
}
