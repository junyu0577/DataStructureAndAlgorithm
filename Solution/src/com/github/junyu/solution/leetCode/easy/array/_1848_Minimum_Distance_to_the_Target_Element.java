package com.github.junyu.solution.leetCode.easy.array;

public class _1848_Minimum_Distance_to_the_Target_Element {

    /*
    Given an integer array nums (0-indexed) and two integers target and start,
    find an index i such that nums[i] == target and abs(i - start) is minimized. Note that abs(x) is the absolute
    value of x.

    Return abs(i - start).

    It is guaranteed that target exists in nums.

    Example 1:

    Input: nums = [1,2,3,4,5], target = 5, start = 3
    Output: 1
    Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
    Example 2:

    Input: nums = [1], target = 1, start = 0
    Output: 0
    Explanation: nums[0] = 1 is the only value equal to target, so the answer is abs(0 - 0) = 0.
    Example 3:

    Input: nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
    Output: 0
    Explanation: Every value of nums is 1, but nums[0] minimizes abs(i - start), which is abs(0 - 0) = 0.


    Constraints:

            1 <= nums.length <= 1000
            1 <= nums[i] <= 104
            0 <= start < nums.length
    target is in nums.
    */

    /**
     * 到目标元素的最小距离,给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，
     * 满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。返回 abs(i - start) 。
     *
     * 逐位比较，然后遇到与target相同的target，就与ans比大小并保留较小值。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance to the Target Element.
     * Memory Usage: 38.9 MB, less than 52.94% of Java online submissions for Minimum Distance to the Target Element.
     *
     * @param nums
     * @param target
     * @param start
     * @return
     */
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==target){
                int distance = Math.abs(i-start);
                ans = Math.min(ans,distance);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1848_Minimum_Distance_to_the_Target_Element test = new _1848_Minimum_Distance_to_the_Target_Element();
        System.out.println(test.getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3));
        System.out.println(test.getMinDistance(new int[]{1}, 1, 0));
        System.out.println(test.getMinDistance(new int[]{1,1,1,1,1,1,1,1,1,1}, 1, 0));
    }
}
