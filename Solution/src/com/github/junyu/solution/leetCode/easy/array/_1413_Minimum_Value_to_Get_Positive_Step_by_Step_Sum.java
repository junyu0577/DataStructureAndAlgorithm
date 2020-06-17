package com.github.junyu.solution.leetCode.easy.array;

public class _1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum {

    /*Given an array of integers nums, you start with an initial positive value startValue.

    In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

    Return the minimum positive value of startValue such that the step by step sum is never less than 1.

    Example 1:

    Input: nums = [-3,2,-3,4,2]
    Output: 5
    Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
    step by step sum
    startValue = 4 | startValue = 5 | nums
            (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
            (1 +2 ) = 3  | (2 +2 ) = 4    |   2
            (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
            (0 +4 ) = 4  | (1 +4 ) = 5    |   4
            (4 +2 ) = 6  | (5 +2 ) = 7    |   2
    Example 2:

    Input: nums = [1,2]
    Output: 1
    Explanation: Minimum start value should be positive.
    Example 3:

    Input: nums = [1,-2,-3]
    Output: 5

    Constraints:

            1 <= nums.length <= 100
            -100 <= nums[i] <= 100*/

    /**
     * 逐步求和得到正数的最小值
     * 思路：累加求得最小的负数值，然后他的绝对值+1即是最小正数。
     * @param nums
     * @return
     */
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            min = Math.min(min,sum);
        }
        return Math.abs(min)+1;
    }

    public static void main(String[] args) {
        _1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum test =
                new _1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum();
        System.out.println(test.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(test.minStartValue(new int[]{1, 2}));
        System.out.println(test.minStartValue(new int[]{1, -2, -3}));
    }
}
