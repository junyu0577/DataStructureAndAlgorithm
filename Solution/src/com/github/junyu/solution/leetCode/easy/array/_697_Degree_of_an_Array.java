package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashMap;
import java.util.Map;

public class _697_Degree_of_an_Array {

    /*Given a non-empty array of non-negative integers nums, the degree of this
    array is defined as the maximum frequency of any one of its elements.

    Your task is to find the smallest possible length of a (contiguous)
    subarray of nums, that has the same degree as nums.

    Example 1:
    Input: [1, 2, 2, 3, 1]
    Output: 2
    Explanation:
    The input array has a degree of 2 because both elements 1 and 2 appear twice.
    Of the subarrays that have the same degree:
            [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    The shortest length is 2. So return 2.
    Example 2:
    Input: [1,2,2,3,1,4,2]
    Output: 6
    Note:

    nums.length will be between 1 and 50,000.
    nums[i] will be an integer between 0 and 49,999.*/

    /**
     * 数组的度的定义是指数组里任一元素出现频数的最大值。
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     * 遍历数组，先统计出现当前数字的出现频率、开始位置和结束，并得到出现频率最高的数。
     * 然后遍历map，查看所有出现频率和最大值相等的，返回间隔最小的长度。
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1)
            return 1;

        int maxFreq = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                int[] arr = new int[3];//频率，开始位置，结束位置
                arr[0] = 1;
                arr[1] = i;
                arr[2] = i;
                map.put(nums[i], arr);
            }
            maxFreq = Math.max(maxFreq, map.get(nums[i])[0]);
        }

        int minLen = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> m : map.entrySet()) {
            if (m.getValue()[0] == maxFreq)
                minLen = Math.min(minLen, m.getValue()[2] - m.getValue()[1] + 1);
        }


        return minLen;
    }


    public static void main(String[] args) {
        _697_Degree_of_an_Array degree_of_an_array = new _697_Degree_of_an_Array();
        System.out.println(degree_of_an_array.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(degree_of_an_array.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(degree_of_an_array.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(degree_of_an_array.findShortestSubArray(new int[]{47, 47, 72, 47, 72, 47, 79, 47, 12, 92, 13, 47, 47, 83, 33, 15, 18, 47, 47, 47, 47, 64, 47, 65, 47, 47, 47, 47, 70, 47, 47, 55, 47, 15, 60, 47, 47, 47, 47, 47, 46, 30, 58, 59, 47, 47, 47, 47, 47, 90, 64, 37, 20, 47, 100, 84, 47, 47, 47, 47, 47, 89, 47, 36, 47, 60, 47, 18, 47, 34, 47, 47, 47, 47, 47, 22, 47, 54, 30, 11, 47, 47, 86, 47, 55, 40, 49, 34, 19, 67, 16, 47, 36, 47, 41, 19, 80, 47, 47, 27}));
    }


}
