package com.github.junyu.solution.leetCode.easy.array;

public class _035_Search_Insert_Position {

/*
    Given a sorted array and a target value, return the index if the target is
    found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:

    Input: [1,3,5,6], 5
    Output: 2
    Example 2:

    Input: [1,3,5,6], 2
    Output: 1
    Example 3:

    Input: [1,3,5,6], 7
    Output: 4
    Example 4:

    Input: [1,3,5,6], 0
    Output: 0*/

    /**
     * 在已排序的数组中查找target对应的索引，如果存在就返回索引，不存在则返回他应该插入的索引位置
     * 很明显主要考察二分查找，如果存在那么mid的值就是他的索引，如果不存在，那么最终left就是他将插入的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 6};
        int val = 2;
        _035_Search_Insert_Position search_insert_position = new _035_Search_Insert_Position();
        System.out.println(search_insert_position.searchInsert(arr, val));
    }
}
