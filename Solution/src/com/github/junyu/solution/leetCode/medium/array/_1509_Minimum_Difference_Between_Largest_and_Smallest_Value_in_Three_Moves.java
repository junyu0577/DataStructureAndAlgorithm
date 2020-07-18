package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;

public class _1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {

   /* Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.

    Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.

    Example 1:

    Input: nums = [5,3,2,4]
    Output: 0
    Explanation: Change the array [5,3,2,4] to [2,2,2,2].
    The difference between the maximum and minimum is 2-2 = 0.
    Example 2:

    Input: nums = [1,5,0,10,14]
    Output: 1
    Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1].
    The difference between the maximum and minimum is 1-0 = 1.
    Example 3:

    Input: nums = [6,6,0,1,1,4,6]
    Output: 2
    Example 4:

    Input: nums = [1,5,6,14,15]
    Output: 1


    Constraints:

            1 <= nums.length <= 10^5
            -10^9 <= nums[i] <= 10^9*/

    /**
     * 三次操作后最大值与最小值的最小差
     * 思路：对数组进行排序，然后获取以下四种情况中的最小值即可
     * 1.去除末尾3个数后的最大值与最小值的差
     * 2.去除头部3个数
     * 3.去除头部1个末尾2个
     * 4.去除头部2个和末尾1个
     * @param nums
     * @return
     */
    public int minDifference(int[] nums) {
        if (nums.length<5)
            return 0;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        min = Math.min(min,nums[nums.length-1]-nums[3]);
        min = Math.min(min,nums[nums.length-1-3]-nums[0]);

        min = Math.min(min,nums[nums.length-1-2]-nums[1]);
        min = Math.min(min,nums[nums.length-1-1]-nums[2]);

        return min;
    }

    public static void main(String[] args) {
        _1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves test = new _1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves();
        System.out.println(test.minDifference(new int[]{5,3,2,4}));
        System.out.println(test.minDifference(new int[]{1,5,0,10,14}));
        System.out.println(test.minDifference(new int[]{6,6,0,1,1,4,6}));
        System.out.println(test.minDifference(new int[]{1,5,6,14,15}));
        System.out.println(test.minDifference(new int[]{82,81,95,75,20}));
    }
}
