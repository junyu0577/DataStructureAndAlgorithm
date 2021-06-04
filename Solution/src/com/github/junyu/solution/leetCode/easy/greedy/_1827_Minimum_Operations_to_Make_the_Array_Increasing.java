package com.github.junyu.solution.leetCode.easy.greedy;

public class _1827_Minimum_Operations_to_Make_the_Array_Increasing {

    /*
    You are given an integer array nums (0-indexed). In one operation, you can choose an element of the array and
    increment it by 1.

    For example, if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].
    Return the minimum number of operations needed to make nums strictly increasing.

    An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1.
    An array of length 1 is trivially strictly increasing.

    Example 1:

    Input: nums = [1,1,1]
    Output: 3
    Explanation: You can do the following operations:
            1) Increment nums[2], so nums becomes [1,1,2].
            2) Increment nums[1], so nums becomes [1,2,2].
            3) Increment nums[2], so nums becomes [1,2,3].


    Example 2:

    Input: nums = [1,5,2,4,1]
    Output: 14
    Example 3:

    Input: nums = [8]
    Output: 0


    Constraints:

            1 <= nums.length <= 5000
            1 <= nums[i] <= 104

*/

    /**
     * 最少操作使数组递增
     * 从左到右遍历，只要保证当前元素比上一个元素大一即可。
     *
     * Runtime: 2 ms, faster than 86.66% of Java online submissions for Minimum Operations to Make the Array Increasing.
     * Memory Usage: 39.1 MB, less than 92.24% of Java online submissions for Minimum Operations to Make the Array Increasing.
     *
     *
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increase = nums[i - 1] - nums[i] + 1;
                ans += increase;
                nums[i] += increase;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1827_Minimum_Operations_to_Make_the_Array_Increasing test =
                new _1827_Minimum_Operations_to_Make_the_Array_Increasing();
        System.out.println(test.minOperations(new int[]{1, 1, 1}));
        System.out.println(test.minOperations(new int[]{1, 5, 2, 4, 1}));
        System.out.println(test.minOperations(new int[]{8}));
    }
}
