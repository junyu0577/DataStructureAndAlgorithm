package com.github.junyu.solution.leetCode.easy.string;

/**
 * @author ShaoJunyu
 * @since 2018/6/14 14:20
 */
public class _007_StringToInteger_atoi {

   /*
    Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
    Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
    and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored
    and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
    exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

            Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
    If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

    Example 1:

    Input: "42"
    Output: 42

    Example 2:

    Input: "   -42"
    Output: -42
    Explanation: The first non-whitespace character is '-', which is the minus sign.
    Then take as many numerical digits as possible, which gets 42.

    Example 3:

    Input: "4193 with words"
    Output: 4193
    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

    Example 4:

    Input: "words and 987"
    Output: 0
    Explanation: The first non-whitespace character is 'w', which is not a numerical
    digit or a +/- sign. Therefore no valid conversion could be performed.
            Example 5:

    Input: "-91283472332"
    Output: -2147483648
    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
            Thefore INT_MIN (−231) is returned.
    */

    /**
     * 思路：startIndex去标识空格后的元素位置，如果是字母开头，也不会进行后续的while循环，其结果为0.
     * 然后判断startIndex位置的元素是否是+/-号，如果是-，symbol置为-1，但凡是+/-，startIndex都需要递增一位
     * 在最后的循环中，排除了字母开头的一些非法的字符。处理超越边界的数,2147483648-2147483649
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int startIndex = 0;
        while (startIndex < str.length() && str.charAt(startIndex) == ' ') {
            startIndex++;
        }

        if (startIndex == str.length()) {
            return 0;
        }

        int symbol = 1;
        if (str.charAt(startIndex) == '+') {
            startIndex++;
        } else if (str.charAt(startIndex) == '-') {
            startIndex++;
            symbol = -1;
        }

        int result = 0;
        while (startIndex < str.length() && str.charAt(startIndex) >= '0' && str.charAt(startIndex) <= '9') {
            if ((result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(startIndex) > '7'))) {
                return symbol == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + str.charAt(startIndex) - '0';
            startIndex++;
        }

        return symbol * result;
    }


    public static void main(String[] args) {
//        String s = "words and 987";
//        String s = "4193 with words";
//        String s = "-91283472332";
//        String s = "-11";
//        String s = "   -42";
//        String s = "+-2";
//        String s = "   +0 123";
//        String s = "-abc";
//        String s = "-   234";
//        String s = "2147483647";
//        String s = "-2147483648";
//        String s = "5555555555555555555";
        String s = "-91283472332";

        System.out.println(myAtoi(s));
    }
}