package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;

public class _912_Sort_an_Array {

    /*Given an array of integers nums, sort the array in ascending order.

    Example 1:

    Input: nums = [5,2,3,1]
    Output: [1,2,3,5]
    Example 2:

    Input: nums = [5,1,1,2,0,0]
    Output: [0,0,1,1,2,5]


    Constraints:

            1 <= nums.length <= 50000
            -50000 <= nums[i] <= 50000*/

    /**
     * 对数组进行排序
     * 思路：使用快排，由于存在重复元素，在partition选取一个元素时随机在区间内筛选。
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int random = (int) (Math.random() * (right - left + 1) + left);
        swap(nums, random, left);

        int target = nums[left];
        int mid = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < target)
                swap(nums, ++mid, i);
        }
        swap(nums, mid, left);
        return mid;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _912_Sort_an_Array test = new _912_Sort_an_Array();
        System.out.println(Arrays.toString(test.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(test.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
