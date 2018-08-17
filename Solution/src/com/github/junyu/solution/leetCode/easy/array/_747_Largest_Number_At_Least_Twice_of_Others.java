package com.github.junyu.solution.leetCode.easy.array;

public class _747_Largest_Number_At_Least_Twice_of_Others {


/*
    In a given integer array nums, there is always exactly one largest element.

    Find whether the largest element in the array is at least twice as much as
    every other number in the array.

    If it is, return the index of the largest element, otherwise return -1.

    Example 1:

    Input: nums = [3, 6, 1, 0]
    Output: 1
    Explanation: 6 is the largest integer, and for every other number in the array x,
            6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


    Example 2:

    Input: nums = [1, 2, 3, 4]
    Output: -1
    Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


    Note:

    nums will have a length in the range [1, 50].
    Every nums[i] will be an integer in the range [0, 99].*/

    /**
     * 找出数组中的最大值，如果他比其他都要大两倍甚至更多，就返回他的索引，否则返回-1
     * 定义两个变量记录上前最大值，以及次大值，遍历完数组就看这最大值是否是次大值的两倍以上
     * 在遍历过程中当前元素大于max，就需要更新lastMax的值和max的值。
     * 如果当前元素仅大于lastMax，也需要更新lastMax的值
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int max = 0;
        int lastMax = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                lastMax = max;
                max = nums[i];
            } else if (nums[i] > lastMax) {
                lastMax = nums[i];
            }
        }

        if (lastMax == 0 || max / lastMax >= 2)
            return index;
        else
            return -1;

    }

    public static void main(String[] args) {
//        int arr [] = {3, 6, 1, 0};
//        int arr[] = {0, 0, 0, 1};
        int arr[] = {0, 0, 3, 2};
        _747_Largest_Number_At_Least_Twice_of_Others largest_number_at_least_twice_of_others = new _747_Largest_Number_At_Least_Twice_of_Others();
        System.out.println(largest_number_at_least_twice_of_others.dominantIndex(arr));
    }
}
