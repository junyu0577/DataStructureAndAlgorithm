package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.ArrayList;
import java.util.List;

public class _1002_Find_Common_Characters {


   /* Given an array A of strings made only from lowercase letters,
            return a list of all characters that show up in all strings within the
    list (including duplicates).  For example, if a character occurs 3 times in all
    strings but not 4 times, you need to include that character three times in the final answer.

    You may return the answer in any order.



            Example 1:

    Input: ["bella","label","roller"]
    Output: ["e","l","l"]
    Example 2:

    Input: ["cool","lock","cook"]
    Output: ["c","o"]


    Note:

            1 <= A.length <= 100
            1 <= A[i].length <= 100
    A[i][j] is a lowercase letter
*/

    /**
     * 统计字符串中相同的字符
     * 通过一个二维数组保存下每个字符串的字符出现的次数，然后从字符a遍历值z，查看二维数组中各字符串出现的字数，
     * 取三者之间的最小值，如果是0则没有共同元素。
     *
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        if (A.length == 1)
            return new ArrayList<>();

        int[][] count = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            char cs[] = A[i].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                count[i][cs[j] - 'a']++;
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < count.length; j++) {
                min = Math.min(min, count[j][i]);
            }
            if (min > 0) {
                for (int k = 0; k < min; k++) {
                    ans.add(String.valueOf((char) ('a' + i)));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _1002_Find_Common_Characters find_common_characters = new _1002_Find_Common_Characters();
        System.out.println(find_common_characters.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(find_common_characters.commonChars(new String[]{"cool", "lock", "cook"}));

    }
}
