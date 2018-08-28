package com.github.junyu.solution.leetCode.medium.sort;

public class _033_Search_in_Rotated_Sorted_Array {

   /* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

            (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.

    Your algorithm's runtime complexity must be in the order of O(log n).

    Example 1:

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Example 2:

    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1*/

    /**
     * 在一个旋转过的数组中查找是否存在指定的元素，存在则返回对应的索引
     * 用二分查找，如果mid正好是target那么就找到了。
     * 剩下的情况就需要看从left到mid是否是有序的，如果有序，就继续判断target是否就在这个区间内，如果是那么将范围小于在left-mid-1，不是就在
     * mid+1 - right。
     * 如果nums[left]>nums[mid],同样，判断target是否在mid+1 - right这个区间，存在则在mid+1-right继续查找，不存在就在left-mid-1查找。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;


        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid])
                return mid;

            if (nums[left] <= nums[mid]) {//left-mid有序
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right])//mid+1 - right 有序
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }


    public static void main(String[] args) {
        System.out.println(new _033_Search_in_Rotated_Sorted_Array().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new _033_Search_in_Rotated_Sorted_Array().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(new _033_Search_in_Rotated_Sorted_Array().search(new int[]{5, 1, 3}, 1));
        System.out.println(new _033_Search_in_Rotated_Sorted_Array().search(new int[]{5, 1, 3}, 5));
        System.out.println(new _033_Search_in_Rotated_Sorted_Array().search(new int[]{3, 1}, 1));
    }

}
