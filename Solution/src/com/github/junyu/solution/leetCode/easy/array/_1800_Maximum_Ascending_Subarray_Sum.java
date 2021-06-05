package com.github.junyu.solution.leetCode.easy.array;

public class _1800_Maximum_Ascending_Subarray_Sum {

   /*
    Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

    A subarray is defined as a contiguous sequence of numbers in an array.

    A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i
    where l <= i < r, numsi < numsi+1. Note that a subarray of size 1 is ascending.

    Example 1:

    Input: nums = [10,20,30,5,10,50]
    Output: 65
    Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
    Example 2:

    Input: nums = [10,20,30,40,50]
    Output: 150
    Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
    Example 3:

    Input: nums = [12,17,15,13,10,11,12]
    Output: 33
    Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
    Example 4:

    Input: nums = [100,10,1]
    Output: 100


    Constraints:

            1 <= nums.length <= 100
            1 <= nums[i] <= 100
*/

    /**
     * 最大升序子数组和
     *
     * 遍历数组，比较当前元素与上一个元素的大小，如果大于前者则继续累加sum。小于前者则在sum与ans中取最大值替换ans，然后将当前元素的值赋给sum，用于进行后续的累加。
     * 最后仍然还要判断下sum和ans的最大值，因为可能最后一个元素也是升序，循环里只进行了累加没有进行替换。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Ascending Subarray Sum.
     * Memory Usage: 38.5 MB, less than 6.91% of Java online submissions for Maximum Ascending Subarray Sum.
     *
     * @param nums
     * @return
     */
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int sum = ans;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                sum+=nums[i];
            }else {
                ans = Math.max(ans,sum);
                sum = nums[i];
            }
        }
        ans = Math.max(ans,sum);
        return ans;
    }

    public static void main(String[] args) {
        _1800_Maximum_Ascending_Subarray_Sum test = new _1800_Maximum_Ascending_Subarray_Sum();
        System.out.println(test.maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(test.maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(test.maxAscendingSum(new int[]{12,17,15,13,10,11,12}));
        System.out.println(test.maxAscendingSum(new int[]{100,10,1}));
    }

}
