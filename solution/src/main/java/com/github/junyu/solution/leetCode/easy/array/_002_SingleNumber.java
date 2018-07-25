package com.github.junyu.solution.leetCode.easy.array;


/**
 * @author ShaoJunyu
 * @since 2018/6/12 16:03
 */
public class _002_SingleNumber {


    /*
        Given a non-empty array of integers, every element appears twice except for one. Find that single one.
        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    */

    /*
        Input: [2,2,1]
        Output: 1
     */

    /**
     * 使用最高效得位运算，如果存在独立得数，最后得结果就是其本身
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {2,2,1};
//        int[] arr = {1, 2, 2};
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr));
    }
}
