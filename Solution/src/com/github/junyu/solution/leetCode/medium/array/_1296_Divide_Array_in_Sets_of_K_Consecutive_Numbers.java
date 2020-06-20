package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;
import java.util.HashMap;

public class _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers {

    /*Given an array of integers nums and a positive integer k, find whether it's
     possible to divide this array into sets of k consecutive numbers

    Return True if its possible otherwise return False.

    Example 1:

    Input: nums = [1,2,3,3,4,4,5,6], k = 4
    Output: true
    Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
    Example 2:

    Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
    Output: true
    Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
    Example 3:

    Input: nums = [3,3,2,2,1,1], k = 3
    Output: true
    Example 4:

    Input: nums = [1,2,3,4], k = 3
    Output: false
    Explanation: Each array should be divided in subarrays of size 3.


    Constraints:

            1 <= nums.length <= 10^5
            1 <= nums[i] <= 10^9
            1 <= k <= nums.length
    Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/*/

    /**
     * 划分数组为连续数字的集合
     * 思路：先统计每个数字出现的数量，然后对数组进行排序。
     * 从升序数组中，按顺序取元素，取到一个元素时，如果他的数量大于0，那么还需要往后取K-1个数组成连续的K个数，如果在取的过程中，取不到
     * 就表示无法组成连续子数组。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(nums);
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            if (count == 0)
                continue;
            map.put(i, --count);
            for (int j = 0; j < k - 1; j++) {
                count = map.getOrDefault(++i, 0);
                if (count == 0)
                    return false;
                map.put(i, --count);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers test =
                new _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers();
        System.out.println(test.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(test.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(test.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
        System.out.println(test.isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
        System.out.println(test.isPossibleDivide(new int[]{8, 8, 9, 9, 10, 10}, 3));


    }
}
