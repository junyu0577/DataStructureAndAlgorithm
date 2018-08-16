package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _561_Array_Partition_I {

/*
    Given an array of 2n integers, your task is to group these integers into n pairs
    of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

    Example 1:
    Input: [1,4,3,2]

    Output: 4
    Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
    Note:
    n is a positive integer, which is in the range of [1, 10000].
    All the integers in the array will be in the range of [-10000, 10000].*/


    /**
     * 给定一个长度为2n的数组，把里面的元素两两一对分出n组，每一组取最小值相加，这个相加的结果最大为多少
     * 先进行一次排序，让0，1  2，3 为一组，如果让0和2n-1为一组，那显然不能获得值。
     * 累加的时候因为时经过排序的，就需要做一次min操作，左边的肯定是最小的
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 2};
        _561_Array_Partition_I array_partition_i = new _561_Array_Partition_I();
        System.out.println(array_partition_i.arrayPairSum(arr));
    }


}
