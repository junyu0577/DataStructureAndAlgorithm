package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1502_Can_Make_Arithmetic_Progression_From_Sequence {

   /* Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the
    difference between any two consecutive elements is the same.

    Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.

    Example 1:

    Input: arr = [3,5,1]
    Output: true
    Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively,
    between each consecutive elements.
    Example 2:

    Input: arr = [1,2,4]
    Output: false
    Explanation: There is no way to reorder the elements to obtain an arithmetic progression.


            Constraints:

            2 <= arr.length <= 1000
            -10^6 <= arr[i] <= 10^6*/

    /**
     * 数组能否形成等差数列
     * 思路：排序后判断两两之间的差值
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _1502_Can_Make_Arithmetic_Progression_From_Sequence test =
                new _1502_Can_Make_Arithmetic_Progression_From_Sequence();
        System.out.println(test.canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(test.canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }
}
