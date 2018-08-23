package com.github.junyu.solution.leetCode.easy.array;

public class _704_Binary_Search {


   /* Given a sorted (in ascending order) integer array nums of n elements and a target value
    , write a function to search target in nums. If target exists, then return its index, otherwise return -1.


    Example 1:

    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4

    Example 2:

    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1


    Note:

    You may assume that all elements in nums are unique.
    n will be in the range [1, 10000].
    The value of each element in nums will be in the range [-9999, 9999].
    */

    /**
     * 用二分查找数组的元素是否存在 存在返回索引，不存在则返回-1
     * 处理在处理left的时候，当target大于数组中所有的元素的时候，left会越界。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if(left==nums.length)
            return -1;
        return nums[left] == target ? left : -1;
    }

    public static void main(String [] args) {
        System.out.println(new _704_Binary_Search().search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(new _704_Binary_Search().search(new int[]{-1,0,3,5,9,12},13));
    }
}
