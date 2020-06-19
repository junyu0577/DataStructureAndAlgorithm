package com.github.junyu.solution.leetCode.medium.array;

import java.util.HashMap;

public class _560_Subarray_Sum_Equals_K {

    /*Given an array of integers and an integer k, you need to find the total number of continuous subarrays
    whose sum equals to k.

            Example 1:

    Input:nums = [1,1,1], k = 2
    Output: 2


    Constraints:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].*/

    /**
     * 和为K的子数组
     * 思路：求前缀和，统计前缀和-k的数量
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
          if (map.containsKey(i-k))
              count+=map.get(i-k);
          map.put(i,map.getOrDefault(i,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        _560_Subarray_Sum_Equals_K test = new _560_Subarray_Sum_Equals_K();
//        System.out.println(test.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(test.subarraySum(new int[]{2, 2, 2}, 2));
//        System.out.println(test.subarraySum(new int[]{1, 1, 2}, 2));
    }
}
