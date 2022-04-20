package com.github.junyu.solution.leetCode.easy.math;

public class _2235_Add_Two_Integers {

/*

    Given two integers num1 and num2, return the sum of the two integers.


    Example 1:

    Input: num1 = 12, num2 = 5
    Output: 17
    Explanation: num1 is 12, num2 is 5, and their sum is 12 + 5 = 17, so 17 is returned.
    Example 2:

    Input: num1 = -10, num2 = 4
    Output: -6
    Explanation: num1 + num2 = -6, so -6 is returned.


    Constraints:

            -100 <= num1, num2 <= 100

*/

    /**
     * 两数之和
     *
     * 题量喜+1
     *
     * @param num1
     * @param num2
     * @return
     */
    public int sum(int num1, int num2) {
        return num1+num2;
    }

    public static void main(String [] args) {
        _2235_Add_Two_Integers test = new _2235_Add_Two_Integers();
        System.out.println(test.sum(12,5));
    }
}
