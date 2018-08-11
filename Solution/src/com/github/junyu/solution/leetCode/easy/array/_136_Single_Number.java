package com.github.junyu.solution.leetCode.easy.array;

public class _136_Single_Number {

/*
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,1]
    Output: 1
    Example 2:

    Input: [4,1,2,1,2]
    Output: 4*/


    /**
     * 找到落单的数，其他的每一个元素都只出现两次
     * 遍历数组，让所有的元素进行异或运算,最终求出的就是落单的数
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            res = res ^ nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 2, 1, 2};
        _136_Single_Number single_number = new _136_Single_Number();
        System.out.println(single_number.singleNumber(arr));
    }
}
