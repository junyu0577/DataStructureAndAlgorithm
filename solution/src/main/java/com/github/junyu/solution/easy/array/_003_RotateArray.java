package com.github.junyu.solution.easy.array;

import java.util.Arrays;

/**
 * @author ShaoJunyu
 * @since 2018/6/12 16:52
 */
public class _003_RotateArray {

   /* Given an array, rotate the array to the right by k steps, where k is non-negative.*/

   /*
    Example 1
    Input: [1,2,3,4,5,6,7] and k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    */

   /*
    Example 2
    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    */

    /**
     * 思路：首先取模处理skip得数大于数组长度得情况。
     * 定义一个长度为skip得临时数组存放待旋转得所有元素。
     * 从skip位置向前遍历，将元素赋值给（当前索引+skip得位置）。
     * 最后遍历临时数组，将里面得值赋值给原数组
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        int[] tempArr = new int[k];
        int index = nums.length - k;
        for (int i = index; i < nums.length; i++) {
            tempArr[i - index] = nums[i];
        }

        for (int i = index - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < tempArr.length; i++) {
            nums[i] = tempArr[i];
        }


        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        int[] arr = {-1};
        rotate(arr, 2);
    }

}
