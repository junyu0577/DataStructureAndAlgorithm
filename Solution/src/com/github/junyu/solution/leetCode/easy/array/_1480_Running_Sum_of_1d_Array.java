package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1480_Running_Sum_of_1d_Array {


    /*Given an array nums. We define a running sum of an array as
    runningSum[i] = sum(nums[0]…nums[i]).

    Return the running sum of nums.

    Example 1:

    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    Example 2:

    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: 
        [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
    Example 3:

    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]


    Constraints:

            1 <= nums.length <= 1000
            -10^6 <= nums[i] <= 10^6
    */

    /**
     * 数组的动态和，当前元素为自身与之前所有元素的总和
     * 思路:当前的元素加上上一个累加结果，然后再将当前元素赋值给sum。
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += sum;
            sum = nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        _1480_Running_Sum_of_1d_Array test = new _1480_Running_Sum_of_1d_Array();
        System.out.println(Arrays.toString(test.runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(test.runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(test.runningSum(new int[]{3, 1, 2, 10, 1})));
    }
}
