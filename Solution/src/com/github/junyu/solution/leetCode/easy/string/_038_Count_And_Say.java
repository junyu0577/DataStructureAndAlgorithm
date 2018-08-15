package com.github.junyu.solution.leetCode.easy.string;


/**
 * @author ShaoJunyu
 * @since 2018/6/21 09:19
 */
public class _038_Count_And_Say {

   /*
    The count-and-say sequence is the sequence of integers with the first five terms as following:

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth term of the count-and-say sequence.

    Note: Each term of the sequence of integers will be represented as a string.

    Example 1:

    Input: 1
    Output: "1"
    Example 2:

    Input: 4
    Output: "1211"
    */

    /**
     * 思路：利用递归，初始值为1，遍历字符数组，count统计相邻重复字符出现次数。
     * 当前的与下一个相同，count++。不同则将结果拼接上count + 当前字符。
     *
     * @param n
     * @return
     */
    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1) + " ";
        char[] cs = s.toCharArray();
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == cs[i + 1]) {
                count++;
            } else {
                result.append(count);
                result.append(cs[i] - '0');
                count = 1;
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {

        System.out.println(countAndSay(4));

    }

}
