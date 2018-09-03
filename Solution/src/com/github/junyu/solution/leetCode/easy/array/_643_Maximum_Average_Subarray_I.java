package com.github.junyu.solution.leetCode.easy.array;

public class _643_Maximum_Average_Subarray_I {

   /* Given an array consisting of n integers, find the contiguous subarray of given length k that
    has the maximum average value. And you need to output the maximum average value.

            Example 1:
    Input: [1,12,-5,-6,50,3], k = 4
    Output: 12.75
    Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
    Note:
            1 <= k <= n <= 30,000.
    Elements of the given array will be in the range [-10,000, 10,000].*/

    /**
     * 在nums中找出k长度的子数组，使得这个子数组的平均数最大
     * 先求出前k个数，并将结果赋值给res，然后从第k个数开始，每次将res加上当前的元素然后再减去i-k个元素，求出下一组的sum，如果这组的sum大于res，那么更新res为
     * sum，最后res保留的就是最大的k个数总和，然后除k获取平均数。
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double res = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            res = Math.max(sum, res);
        }

        return res / k;
    }

    public static void main(String[] args) {
        System.out.println(new _643_Maximum_Average_Subarray_I().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(new _643_Maximum_Average_Subarray_I().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3, 100}, 4));
        System.out.println(new _643_Maximum_Average_Subarray_I().findMaxAverage(new int[]{5}, 1));
        System.out.println(new _643_Maximum_Average_Subarray_I().findMaxAverage(new int[]{-1}, 1));
    }
}
