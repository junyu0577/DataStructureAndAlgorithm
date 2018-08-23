package com.github.junyu.solution.leetCode.hard.array;

public class _154_Find_Minimum_in_Rotated_Sorted_Array_II {

  /*  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

            (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

    Find the minimum element.

    The array may contain duplicates.

            Example 1:

    Input: [1,3,5]
    Output: 1
    Example 2:

    Input: [2,2,2,0,1]
    Output: 0
    Note:

    This is a follow up problem to Find Minimum in Rotated Sorted Array.
    Would allow duplicates affect the run-time complexity? How and why?*/

    /**
     * 在153的基础上，这题里的数组中存在重复的元素
     * 既然存在重复元素，二分查找的满足条件就是只要left>=right,我们就进行查找，如果数组中不存在重复元素，那么之前的right-left=1时，right就是最小值的条件
     * 依然成立。
     * 如果有重复的元素，并且mid、left和right所指的值都相等，那么这时就无法考查区间内最小的元素，这时就在left和right区间内使用顺序查找找出最小值
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = nums.length - 1;
        int midIndex = left;

        while (nums[left] >= nums[right]) {
            if (right - left == 1) {
                midIndex = right;
                break;
            }

            int mid = (right - left) / 2 + left;

            if (nums[right] == nums[left] && nums[mid] == nums[right]) {
                midIndex = findMin(nums, left, right);
                break;
            }

            if (nums[mid] >= nums[left]) {
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }

        return nums[midIndex];

    }

    private int findMin(int[] nums, int left, int right) {
        int min = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[min])
                min = i;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new _154_Find_Minimum_in_Rotated_Sorted_Array_II().findMin(new int[]{1, 3, 5}));
        System.out.println(new _154_Find_Minimum_in_Rotated_Sorted_Array_II().findMin(new int[]{2, 2, 2, 0, 1}));
    }

}
