package com.github.junyu.solution.leetCode.easy.array;

public class _2239_Find_Closest_Number_to_Zero {

/*
    Given an integer array nums of size n, return the number with the value closest to 0
    in nums. If there are multiple answers, return the number with the largest value.


    Example 1:

    Input: nums = [-4,-2,1,4,8]
    Output: 1
    Explanation:
    The distance from -4 to 0 is |-4| = 4.
    The distance from -2 to 0 is |-2| = 2.
    The distance from 1 to 0 is |1| = 1.
    The distance from 4 to 0 is |4| = 4.
    The distance from 8 to 0 is |8| = 8.
    Thus, the closest number to 0 in the array is 1.

    Example 2:

    Input: nums = [2,-1,1]
    Output: 1
    Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.


    Constraints:

            1 <= n <= 1000
            -105 <= nums[i] <= 105
    */

    /**
     * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。
     * 如果有多个答案，请你返回它们中的 最大值 。
     *
     * Runtime: 2 ms, faster than 78.71% of Java online submissions for Find Closest Number to Zero.
     * Memory Usage: 51.3 MB, less than 18.38% of Java online submissions for Find Closest Number to Zero.
     *
     * 遍历数组，两种情况，如果当前的数的绝对值小于dif就更新ans和dif。
     * 如果相等并且当前的数的值大于ans，就更新ans。因为要取正数而不是负数。
     *
     * @param nums
     * @return
     */
    public int findClosestNumber(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int dif = Integer.MAX_VALUE;

        for (int i : nums) {
            if (Math.abs(i) < dif){
                ans = i;
                dif = Math.abs(i);
            } else if (Math.abs(i) == dif && i>ans){
                ans = i;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        _2239_Find_Closest_Number_to_Zero test = new _2239_Find_Closest_Number_to_Zero();
        System.out.println(test.findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(test.findClosestNumber(new int[]{2, -1, 1}));
    }
}
