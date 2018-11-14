package com.github.junyu.solution.leetCode.medium.array;

public class _162_Find_Peak_Element {


  /*  A peak element is an element that is greater than its neighbors.

    Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

    You may imagine that nums[-1] = nums[n] = -∞.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.
    Example 2:

    Input: nums = [1,2,1,3,5,6,4]
    Output: 1 or 5
    Explanation: Your function can return either index number 1 where the peak element is 2,
    or index number 5 where the peak element is 6.
    Note:

    Your solution should be in logarithmic complexity.*/

    /**
     * 寻找峰值，存在多个峰值就返回任意一个
     * 进行线性查找，不断比较相邻的两个元素，如果当前的小于上一个元素，就返回上一个元素的索引
     * 时间复杂度O(n)
     *
     * @param nums
     * @return
     */
//    public int findPeakElement(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] > nums[i])
//                return i - 1;
//        }
//
//        return nums.length - 1;
//    }



    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }

        return left;

    }

    public static void main(String[] args) {
        _162_Find_Peak_Element find_peak_element = new _162_Find_Peak_Element();
        System.out.println(find_peak_element.findPeakElement(new int[]{3, 2, 1}));
        System.out.println(find_peak_element.findPeakElement(new int[]{9, 10, 1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(find_peak_element.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(find_peak_element.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
