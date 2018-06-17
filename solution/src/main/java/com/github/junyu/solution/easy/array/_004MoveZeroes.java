package com.github.junyu.solution.easy.array;

import java.util.Arrays;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/12 20:16
 */
public class _004MoveZeroes {

    /*
        Given an array nums, write a function to move all 0's to the end of it while maintaining
        the relative order of the non-zero elements.
    */


    /*
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    */

    /*
    note
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
    */

    /**
     * 思路:定义zeroCount记录0的数量，point去指向最左的0，point在第一次遇见0后用i赋值。
     * 当遇见非0时交换i和point位置的元素，并递增point去指向最左的0
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        int zeroCount = 0, point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroCount == 0) {
                    point = i;
                }
                zeroCount++;
            } else if (zeroCount > 0) {
                int temp = nums[point];
                nums[point] = nums[i];
                nums[i] = temp;
                point++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 3, 4, 5, 0, 6, 7};
//        int[] arr = {0,1,2};
//        int[] arr = {0,1};
//        int[] arr = {0};
        moveZeroes(arr);
    }

}
