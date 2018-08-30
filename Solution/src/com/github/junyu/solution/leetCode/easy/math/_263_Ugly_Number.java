package com.github.junyu.solution.leetCode.easy.math;

public class _263_Ugly_Number {

   /* Write a program to check whether a given number is an ugly number.

    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

    Example 1:

    Input: 6
    Output: true
    Explanation: 6 = 2 × 3
    Example 2:

    Input: 8
    Output: true
    Explanation: 8 = 2 × 2 × 2
    Example 3:

    Input: 14
    Output: false
    Explanation: 14 is not ugly since it includes another prime factor 7.
    Note:

            1 is typically treated as an ugly number.
    Input is within the 32-bit signed integer range: [−231,  231 − 1].*/

    /**
     * 判断一个数是否是丑数，丑数的定义是他的因子只包含2，3，5.
     * 先排除掉0及以下的数。
     * 尝试对num除以2，3，5进行取模，如果能被其中一个数整除，那么就进行除法操作。如果都不同整除，那么再看num是否等于1，为1就说明是一个丑数。
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;

        while (num % 2 == 0)
            num = num >> 1;

        while (num % 3 == 0)
            num /= 3;

        while (num % 5 == 0)
            num /= 5;

        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new _263_Ugly_Number().isUgly(6));
        System.out.println(new _263_Ugly_Number().isUgly(8));
        System.out.println(new _263_Ugly_Number().isUgly(14));
        System.out.println(new _263_Ugly_Number().isUgly(-6));
        System.out.println(new _263_Ugly_Number().isUgly(-2147483648));


    }

}
