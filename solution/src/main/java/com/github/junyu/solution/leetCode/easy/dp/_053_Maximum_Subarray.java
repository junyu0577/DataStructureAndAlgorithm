package com.github.junyu.solution.leetCode.easy.dp;

/**
 * @author ShaoJunyu
 * @since 2018/8/2 11:52
 */
public class _053_Maximum_Subarray {

  /*  Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:

    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    */


    private int max;
    private int[] memo;

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];


        memo = new int[nums.length];
        max = nums[0];
        memo[0] = max;

        countMax(nums, 1, nums[1]);

        return max;

    }

    private void countMax(int[] nums, int index, int num) {

        memo[index] = nums[index] + Math.max(memo[index - 1], 0);
        max = Math.max(memo[index], max);

        if (index == nums.length - 1)
            return;

        countMax(nums, index + 1, num + nums[index + 1]);

    }


//    private int[] memo;
//
//    /**
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return 0;
//
//        memo = new int[nums.length];
//        int max = nums[0];
//        memo[0] = max;
//
//        for (int i = 1; i < nums.length; i++) {
//            memo[i] = nums[i] + Math.max(memo[i - 1], 0);
//            max = Math.max(max, memo[i]);
//        }
//
//        return max;
//    }


    public static void main(String[] args) {
//        int arr[] = {1, -2, 3};
//        int arr[] = {1, 2, 3};
//        int arr[] = {1, 2};
        int arr[] = {-1};
//        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        _053_Maximum_Subarray maximum_subarray = new _053_Maximum_Subarray();
        System.out.println(maximum_subarray.maxSubArray(arr));
    }

}
