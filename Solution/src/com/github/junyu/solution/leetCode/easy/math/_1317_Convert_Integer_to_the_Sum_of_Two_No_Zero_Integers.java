package com.github.junyu.solution.leetCode.easy.math;

import java.util.Arrays;

public class _1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers {

    /*Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal
    representation.

    Return a list of two integers [A, B] where:

    A and B are No-Zero integers.
    A + B = n
    It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of
     them.

    Example 1:

    Input: n = 2
    Output: [1,1]
    Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
    Example 2:

    Input: n = 11
    Output: [2,9]
    Example 3:

    Input: n = 10000
    Output: [1,9999]
    Example 4:

    Input: n = 69
    Output: [1,68]
    Example 5:

    Input: n = 1010
    Output: [11,999]


    Constraints:

            2 <= n <= 10^4*/

    /**
     * 找到两个和为n的不含零的整数
     * 思路：通过不断增大left和减少right，同时判断这两个数中是否含有0。
     * @param n
     * @return
     */
    public int[] getNoZeroIntegers(int n) {
        int left = 1;
        int right = n - 1;
        while (true) {
            if (!containZero(left) && !containZero(right)) {
                break;
            }
            left++;
            right--;
        }
        return new int[]{left, right};
    }

    private boolean containZero(int num) {
        while (num != 0) {
            if (num % 10 == 0)
                return true;
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        _1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers test =
                new _1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers();
        System.out.println(Arrays.toString(test.getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(test.getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(test.getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(test.getNoZeroIntegers(69)));
        System.out.println(Arrays.toString(test.getNoZeroIntegers(1010)));
    }
}
