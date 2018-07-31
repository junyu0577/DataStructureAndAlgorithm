package com.github.junyu.solution.leetCode.easy.math;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/25 22:39
 */
public class _002_Power_of_Three {

 /*   Given an integer, write a function to determine if it is a power of three.

    Example 1:

    Input: 27
    Output: true
    Example 2:

    Input: 0
    Output: false
    Example 3:

    Input: 9
    Output: true
    Example 4:

    Input: 45
    Output: false
    Follow up:
    Could you do it without using any loop / recursion?*/

    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;

        if (n == 1)
            return true;

        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

//    /**
//     * 在正数范围内3的最大次方数为1162261467，如果是能够被其整除就是三的次方数
//      * @param n
//     * @return
//     */
//    public static boolean isPowerOfThree(int n) {
//        return (n > 0 && 1162261467 % n == 0);
//    }

    public static void main(String args[]) {
        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThree(3));
    }
}
