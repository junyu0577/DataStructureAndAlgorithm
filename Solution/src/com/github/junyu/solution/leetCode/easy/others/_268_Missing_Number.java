package com.github.junyu.solution.leetCode.easy.others;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/30 22:40
 */
public class _268_Missing_Number {
/*    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
      find the one that is missing from the array.

            Example 1:

    Input: [3,0,1]
    Output: 2
    Example 2:

    Input: [9,6,4,2,3,5,7,0,1]
    Output: 8
    Note:
    Your algorithm should run in linear runtime complexity. Could you implement it using only
    constant extra space complexity?*/

    /**
     * 寻找丢失的数
     * 求出数组元素的总和，nums+nums.length的值-nums数组的总和就是缺少的数
     * 也可以用(0 + n) * (n + 1) / 2 公式计算出总值后再减去nums数组的总和，这样可以大大的减少
     * 累加操作。
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int res = 0;
        int sums = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            sums+=i;
        }

        return sums - res;
    }

    public  static void main(String [] args){
//        int arr [] = {3,0,1};
        int arr [] = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }

}
