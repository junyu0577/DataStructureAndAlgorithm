package com.github.junyu.solution.easy.array;

import java.util.Arrays;

/**
 * @author ShaoJunyu
 * @since 2018/6/13 08:25
 */
public class _005_ContainsDuplicate {

   /*
    Given an array of integers, find if the array contains any duplicates.
    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
    */

   /*
    Example 1:

    Input: [1,2,3,1]
    Output: true

    Input: [1,2,3,4]
    Output: false

    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true
    */

    /**
     * 先对数组进行排序，然后比较相邻得两个元素是否相等得出结果，这样保证了效率又没有造成空间上得消耗
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 0, 0, 3, 4, 5, 0, 6, 7};
        int[] arr = {0, 1, 2};
//        int[] arr = {0,1};
//        int[] arr = {0};
        System.out.println(containsDuplicate(arr));
    }
}
