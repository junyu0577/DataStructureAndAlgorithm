package com.github.junyu.solution.leetCode.easy.string;

public class _1374_Generate_a_String_With_Characters_That_Have_Odd_Counts {

   /* Given an integer n, return a string with n characters such that each character in such string
    occurs an odd number of times.

    The returned string must contain only lowercase English letters. If there are multiples valid
    strings, return any of them.

    Example 1:

    Input: n = 4
    Output: "pppz"
    Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z'
    occurs once. Note that there are many other valid strings such as "ohhh" and "love".
    Example 2:

    Input: n = 2
    Output: "xy"
    Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many
    other valid strings such as "ag" and "ur".
    Example 3:

    Input: n = 7
    Output: "holasss"


    Constraints:
    1 <= n <= 500*/

    /**
     * 组成每个字符都是奇数个数的字符串，长度为n
     * 思路，如果长度是奇数，那么整个字符串内容全是a，如果是偶数，那么就只有1一个a字符其余都是b字符。
     * 首先添加进一个字符a，然后判断剩余的长度是奇数还是偶数，如果是偶数，那么就把剩余的长度全部添加为a。
     * 如果是剩下的长度是奇数，那么剩余的长度全部添加b字符。
     * @param n
     * @return
     */
    public String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append('a');
        n--;
        if ((n & 1) == 0) {
            while (n > 0) {
                ans.append('a');
                n--;
            }
        } else {//odd
            while (n > 0) {
                ans.append('b');
                n--;
            }

        }
        return ans.toString();
    }

    public static void main(String[] args) {
        _1374_Generate_a_String_With_Characters_That_Have_Odd_Counts test =
                new _1374_Generate_a_String_With_Characters_That_Have_Odd_Counts();
        System.out.println(test.generateTheString(4));
        System.out.println(test.generateTheString(2));
        System.out.println(test.generateTheString(7));
    }
}
