package com.github.junyu.solution.leetCode.easy.greedy;

public class _1758_Minimum_Changes_To_Make_Alternating_Binary_String {

/*
    You are given a string s consisting only of the characters '0' and '1'. In one operation,
    you can change any '0' to '1' or vice versa.

    The string is called alternating if no two adjacent characters are equal. For example, the string "010" is
    alternating,
    while the string "0100" is not.

    Return the minimum number of operations needed to make s alternating.

    Example 1:

    Input: s = "0100"
    Output: 1
    Explanation: If you change the last character to '1', s will be "0101", which is alternating.

    Example 2:

    Input: s = "10"
    Output: 0
    Explanation: s is already alternating.


    Example 3:

    Input: s = "1111"
    Output: 2
    Explanation: You need two operations to reach "0101" or "1010".

    Constraints:

            1 <= s.length <= 104
    s[i] is either '0' or '1'.
    */

    /**
     * 生成交替二进制字符串的最少操作数
     * 分别统计偶数位为0奇数位为1与偶数位为1奇数位为0时需要变动的数量，变动较少的为最少操作数。
     *
     * Runtime: 3 ms, faster than 69.96% of Java online submissions for Minimum Changes To Make Alternating Binary String.
     * Memory Usage: 38.7 MB, less than 89.16% of Java online submissions for Minimum Changes To Make Alternating Binary String.
     *
     * @param s
     * @return
     */
    public int minOperations(String s) {
        int odd = 0;
        int even = 0;

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)%2 != i%2){//偶数位不为0，偶数位需要变动
                even++;
            } else {
                odd++;
            }

        }

        return Math.min(odd,even);
    }

    public static void main(String[] args) {
        _1758_Minimum_Changes_To_Make_Alternating_Binary_String test =
                new _1758_Minimum_Changes_To_Make_Alternating_Binary_String();
        System.out.println(test.minOperations("0100"));
        System.out.println(test.minOperations("10"));
        System.out.println(test.minOperations("1111"));
        System.out.println(test.minOperations("10010100"));
        System.out.println(test.minOperations("001100011"));

    }
}
