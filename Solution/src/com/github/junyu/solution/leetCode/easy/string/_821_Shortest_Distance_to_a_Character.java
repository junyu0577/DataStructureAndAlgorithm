package com.github.junyu.solution.leetCode.easy.string;

import java.util.Arrays;

public class _821_Shortest_Distance_to_a_Character {

  /*  Given a string S and a character C, return an array of integers representing the
    shortest distance from the character C in the string.

            Example 1:

    Input: S = "loveleetcode", C = 'e'
    Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


    Note:

    S string length is in [1, 10000].
    C is a single character, and guaranteed to be in string S.
    All letters in S and C are lowercase.*/

    /**
     * 遍历字符数组中的每一个元素，以它为中心，向左或向后向两边去查找和C的最短距离,当左边找到一个距离后，就再向右边去找，如果右边的距离比左边
     * 更短，则更新这个距离,并结束本轮查找
     *
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar(String S, char C) {
        char cs[] = S.toCharArray();
        int res[] = new int[S.length()];
        for (int i = 0; i < cs.length; i++) {
            int distance = Integer.MAX_VALUE;
            int cur = i;
            while (cur >= 0) {//去左边查找
                if (cs[cur] == C) {
                    distance = i - cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < cs.length) {//去右边查找
                if (cs[cur] == C) {
                    if ((cur - i) < distance)
                        distance = cur - i;
                    break;
                }
                cur++;
            }
            res[i] = distance;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _821_Shortest_Distance_to_a_Character().shortestToChar("loveleetcode", 'e')));
    }

}
