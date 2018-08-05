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

        memo = new int[nums.length];
        memo[0] = nums[0];
        max = memo[0];

        countMax(nums, 1);

        return max;
    }


    private void countMax(int[] nums, int index) {

        if (index >= nums.length)
            return;

        memo[index] = Math.max(memo[index - 1], 0) + nums[index];
        max = Math.max(memo[index], max);

        countMax(nums, index + 1);
    }


//    /**
//     * 假设memo[i]为nums[0,i]的最大值，
//     * 可以得出memo[i+1] = max(memo[i],memo[i+1])+nums[i+1]
//     *
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return 0;
//
//
//        int[] memo = new int[nums.length];
//        memo[0] = nums[0];
//        int max = memo[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            memo[i] = Math.max(memo[i - 1], 0) + nums[i];
//            max = Math.max(memo[i], max);
//        }
//
//        return max;
//
//    }


    public static void main(String[] args) {
//        int arr[] = {1, -2, 3};
//        int arr[] = {1, 2, 3};
//        int arr[] = {1, 2};
//        int arr[] = {-1};
        int arr[] = {-2,1};
//        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        _053_Maximum_Subarray maximum_subarray = new _053_Maximum_Subarray();
        System.out.println(maximum_subarray.maxSubArray(arr));
    }

}
