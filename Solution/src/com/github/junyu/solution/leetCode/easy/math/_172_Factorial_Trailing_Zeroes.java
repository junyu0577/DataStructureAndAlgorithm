package com.github.junyu.solution.leetCode.easy.math;

public class _172_Factorial_Trailing_Zeroes {

    /*Given an integer n, return the number of trailing zeroes in n!.

    Example 1:

    Input: 3
    Output: 0
    Explanation: 3! = 6, no trailing zero.
            Example 2:

    Input: 5
    Output: 1
    Explanation: 5! = 120, one trailing zero.
            Note: Your solution should be in logarithmic time complexity.*/

    /**
     * n的阶乘后，数尾数有几个0
     * 如果先计算阶乘，那么会存在整形溢出问题。
     * 换一种思路，考虑1-5之间，2和5的乘积就能得到1个0，6-10中因为有10，又多一个0，11-15中，12和15的乘积又多一个0，所以
     * 每5个数就会多一个0。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {

        int count = 0;

        while (n > 4) {
            count += n / 5;
            n = n / 5;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _172_Factorial_Trailing_Zeroes().trailingZeroes(3));
        System.out.println(new _172_Factorial_Trailing_Zeroes().trailingZeroes(5));
        System.out.println(new _172_Factorial_Trailing_Zeroes().trailingZeroes(7));
        System.out.println(new _172_Factorial_Trailing_Zeroes().trailingZeroes(10));
        System.out.println(new _172_Factorial_Trailing_Zeroes().trailingZeroes(13));
        System.out.println(new _172_Factorial_Trailing_Zeroes().trailingZeroes(15));
    }
}
