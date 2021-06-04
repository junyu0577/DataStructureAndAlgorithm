package com.github.junyu.solution.leetCode.easy.math;

public class _1822_Sign_of_the_Product_of_an_Array {

/*

    There is a function signFunc(x) that returns:

         1 if x is positive.
        -1 if x is negative.
         0 if x is equal to 0.
        You are given an integer array nums. Let product be the product of all values in the array nums.

    Return signFunc(product).



    Example 1:

    Input: nums = [-1,-2,-3,-4,3,2,1]
    Output: 1
    Explanation: The product of all values in the array is 144, and signFunc(144) = 1
    Example 2:

    Input: nums = [1,5,0,2,-3]
    Output: 0
    Explanation: The product of all values in the array is 0, and signFunc(0) = 0
    Example 3:

    Input: nums = [-1,1,-1,1,-1]
    Output: -1
    Explanation: The product of all values in the array is -1, and signFunc(-1) = -1


    Constraints:

            1 <= nums.length <= 1000
            -100 <= nums[i] <= 100
*/

    /**
     * 数组元素积的符号
     * 如果数组中包含了0，那么结果肯定为0.否则就统计小于0的数字数量，如果小于0的数量是偶数，这么结果必为正数，反之为负数。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sign of the Product of an Array.
     * Memory Usage: 38.6 MB, less than 65.57% of Java online submissions for Sign of the Product of an Array.
     * @param nums
     * @return
     */
    public int arraySign(int[] nums) {
        int blowZeroCount = 0;
        for (int num : nums) {
            if (num == 0)
                return 0;
            else if (num < 0) {
                blowZeroCount++;
            }
        }
        return blowZeroCount%2==0?1:-1;
    }

    public static void main(String[] args) {
        _1822_Sign_of_the_Product_of_an_Array test = new _1822_Sign_of_the_Product_of_an_Array();
        System.out.println(test.arraySign(new int[]{-1,-2,-3,-4,3,2,1}));
        System.out.println(test.arraySign(new int[]{1,5,0,2,-3}));
        System.out.println(test.arraySign(new int[]{-1,1,-1,1,-1}));
    }
}
