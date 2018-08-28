package com.github.junyu.solution.leetCode.medium.sort;

public class _215_Kth_Largest_Element_in_an_Array {

   /* Find the kth largest element in an unsorted array. Note that it is the kth largest
    element in the sorted order, not the kth distinct element.

    Example 1:

    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    Example 2:

    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
    Note:
    You may assume k is always valid, 1 ≤ k ≤ array's length.*/

    /**
     * 找出第k大的数，这题主要考查对于快排的运用
     * 在partition的操作中每次都会将一个元素交换到它应该所处的位置，并返回相应的索引，
     * 同时让partition是将元素按从大到小的排列方式进行组织，
     * 那么得到的索引如果是k-1，那么正是要找的第k大的元素。
     * 如果索引小于k-1，那么就要去右边进行partition操作
     * 如果大于k-1，去左边进行partition操作
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int mid = partition(left, right, nums);
            if (mid == k - 1) {
                return nums[mid];
            } else if (mid > k - 1) {//去左边进行partition
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private int partition(int left, int right, int[] nums) {
        swap(left, (int) (Math.random() * (right - left + 1) + left), nums);

        int target = nums[left];
        int j = left;
        for (int i = j + 1; i <= right; i++) {
            if (nums[i] > target) {
                j++;
                swap(i, j, nums);
            }
        }
        swap(j, left, nums);
        return j;
    }

    private void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

    }

    public static void main(String[] args) {
        System.out.println(new _215_Kth_Largest_Element_in_an_Array().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new _215_Kth_Largest_Element_in_an_Array().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
