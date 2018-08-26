package com.github.junyu.solution.leetCode.easy.math;

public class _342_Power_of_Four {

   /* Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

    Example 1:

    Input: 16
    Output: true
    Example 2:

    Input: 5
    Output: false
    Follow up: Could you solve it without loops/recursion?*/

    /**
     * 判断num是否是4的幂
     * num能被4整除，就不断的/4缩小值，直到num为1，说明是4的幂，否则就不是
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        if (num == 0)
            return false;

        while (num % 4 == 0) {
            num = num / 4;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new _342_Power_of_Four().isPowerOfFour(16));
        System.out.println(new _342_Power_of_Four().isPowerOfFour(5));
        System.out.println(new _342_Power_of_Four().isPowerOfFour(1));
        System.out.println(new _342_Power_of_Four().isPowerOfFour(0));
    }

}
