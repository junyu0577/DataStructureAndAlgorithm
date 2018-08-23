package com.github.junyu.solution.leetCode.easy.others;

public class _287_Find_the_Duplicate_Number {


  /*  Given an array nums containing n + 1 integers where each
    integer is between 1 and n (inclusive), prove that at least one duplicate
    number must exist. Assume that there is only one duplicate number, find the duplicate one.

            Example 1:

    Input: [1,3,4,2,2]
    Output: 2
    Example 2:

    Input: [3,1,3,4,2]
    Output: 3
    Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.
    */

    /**
     * 找出重复的数
     * 限制不能使用额外空间，不为改变原数组，时间复杂度还要小于n^2
     * 使用二分查找，left从1开始，right从数组长度-1开始，每次取一个mid值，然后遍历数组，统计小于等于mid出现的次数。
     * 如果少于等于mid的，说明没有重复数，那么就将范围缩到mid+1到right之间
     * 要是大于mid，就有重复值，那就再left和mid-1之间，挑选mid值去遍历数组查找继续统计小于等于mid出现的次数
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right-left)/2+left;
            int count = 0;
            for (int i : nums){
                if (i<=mid)
                    count++;
            }
            if (count<=mid){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new _287_Find_the_Duplicate_Number().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new _287_Find_the_Duplicate_Number().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

}
