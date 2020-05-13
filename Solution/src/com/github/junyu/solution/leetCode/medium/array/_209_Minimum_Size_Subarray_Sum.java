package com.github.junyu.solution.leetCode.medium.array;

public class _209_Minimum_Size_Subarray_Sum {

    /*Given an array of n positive integers and a positive integer s,
    find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    Example:

    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.
    Follow up:
    If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).*/

    /**
     * 寻找累加之和大于等于给定s的最短子串的长度
     * 思路：利用滑动窗口算法，先滑动右指针，进行窗口元素的求和，当发现sum大于给定的s时，去用当前的窗口长度去更新最短子串的值。然后左指针右移，
     * 并从sum中减掉从窗口中被移除的元素。重复移动左指针，直到窗口的元素和不满足大于等于s，再继续去移动右指针。
     * 给定的数组可能会为空，所以最后判断如果长度是整形的最大值，那就返回0。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                minSize = Math.min(right - left + 1, minSize);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {
        _209_Minimum_Size_Subarray_Sum test = new _209_Minimum_Size_Subarray_Sum();
        System.out.println(test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(test.minSubArrayLen(100, new int[]{}));
    }
}
