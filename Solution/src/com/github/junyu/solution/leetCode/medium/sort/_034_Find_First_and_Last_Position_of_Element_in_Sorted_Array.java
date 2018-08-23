package com.github.junyu.solution.leetCode.medium.sort;

import java.util.Arrays;

public class _034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

   /* Given an array of integers nums sorted in ascending order,
    find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]*/

    /**
     * 找出数组中和target的相同的所有元素，返回这些元素的第一个索引和最后一个索引
     * 用二分查找先找出target相等的元素，如果没有就返回[-1,-1].
     * 如果找到了target的位置，那么还需要查找一下target位置左边以及右边的元素是否和target相等，相等就需要更新
     * 要返回的start和end的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                left = mid;
                break;
            } else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        if (left > nums.length - 1 || nums[left] != target)
            return new int[]{-1, -1};

        int start = left;
        int end = left;
        int cur = left;
        while (cur > 0) {
            if (nums[cur] == nums[cur - 1]) {
                start = cur - 1;
                cur--;
            } else
                break;
        }

        while (left < right) {
            if (nums[left] == nums[left + 1]) {
                end = left + 1;
                left++;
            } else {
                break;
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _034_Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new _034_Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new _034_Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(new int[]{2,2}, 3)));
        System.out.println(Arrays.toString(new _034_Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(new int[]{1, 2, 3}, 2)));
    }
}
