package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {

   /* Given an array nums of n integers where n > 1,  return an array output
    such that output[i] is equal to the product of all the elements of nums
    except nums[i].

    Example:

    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Constraint: It's guaranteed that the product of the elements of any prefix
    or suffix of the array (including the whole array) fits in a 32 bit integer.

    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
    */

    /**
     * 除自身以外数组的乘积
     * 思路：先从左往右计算除当前元素以外左侧元素的乘积赋值给结果数组。
     * 然后再从右往左计算除自身外右侧的元素与左侧元素的乘积。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 1;
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            sum *= nums[i - 1];
            ans[i] = sum;
        }
        sum = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sum *= nums[i + 1];
            ans[i] = ans[i] * sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        _238_Product_of_Array_Except_Self test = new _238_Product_of_Array_Except_Self();
        System.out.println(Arrays.toString(test.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(test.productExceptSelf(new int[]{2, 1, 0})));
    }
}
