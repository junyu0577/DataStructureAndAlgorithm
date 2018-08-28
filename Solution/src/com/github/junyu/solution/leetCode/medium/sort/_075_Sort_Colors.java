package com.github.junyu.solution.leetCode.medium.sort;

import java.util.Arrays;

public class _075_Sort_Colors {

/*    Given an array with n objects colored red, white or blue, sort them in-place 
    so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

            Note: You are not suppose to use the library's sort function for this problem.

    Example:

    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    Follow up:

    A rather straight forward solution is a two-pass algorithm using counting sort.
            First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
    then 1's and followed by 2's.
    Could you come up with a one-pass algorithm using only constant space?*/

    /**
     * 对数组做排序
     * 用hash表保存0-2出现的次数，第一次遍历数组的时候，统计次数
     * ，然后遍历arr数组，替换更新原数组的内容,由于每一个元素都代表出现的各自出现的次数，
     * 里面也需要进行内循环，但是总体时间复杂度仍然是O(N)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int arr[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            int p = arr[i];
            while (p > 0) {
                nums[cur] = i;
                p--;
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 0, 2, 1, 1, 0};
        new _075_Sort_Colors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
