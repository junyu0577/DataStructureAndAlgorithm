package com.github.junyu.solution.leetCode.medium.array;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {

   /* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

            (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

    Find the minimum element.

    You may assume no duplicate exists in the array.

            Example 1:

    Input: [3,4,5,1,2]
    Output: 1
    Example 2:

    Input: [4,5,6,7,0,1,2]
    Output: 0*/

    /**
     * 找出数组中的最小值，原先的数组是完全升序，但是被旋转一次之后，就可能变成了两个升序数组
     * 估计这个性质，那么旋转后的数组中第1个元素必定大于最后一个元素，这题可以使用二分查找去实现
     * 题目限定了没有重复元素，那么当出现第一个元素小于最后一个元素时，就说明此时数组已经是一个排过序的数组,直接返回midIndex
     * 在二分查找的过程中，只要左边的指针所指的值大于右边，我们就去查找。只有当范围缩小到right-left=1的时候，就说明left已经为序第一个升序
     * 数组的最后一个元素，而right指针在第二个升序子数组的第一个元素。那么right所指即使最小的元素。
     * 缩小范围的时候，无论的左还是右，仍然要继续考察mid位置的元素。
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = nums.length - 1;
        int midIndex = left;


        while (nums[left] > nums[right]) {
            if (right - left == 1) {
                midIndex = right;
                break;
            }

            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[left])
                left = mid;
            else if (nums[mid] < nums[right])
                right = mid;

        }

        return nums[midIndex];

    }

    public static void main(String[] args) {
        System.out.println(new _153_Find_Minimum_in_Rotated_Sorted_Array().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new _153_Find_Minimum_in_Rotated_Sorted_Array().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
