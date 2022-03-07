package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements {

    /*

    Given an integer array nums, return the number of elements that have both a strictly
    smaller and a strictly greater element appear in nums.


    Example 1:

    Input: nums = [11,7,2,15]
    Output: 2
    Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
    Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
    In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.
    Example 2:

    Input: nums = [-3,3,3,90]
    Output: 2
    Explanation: The element 3 has the element -3 strictly smaller than it and the element 90 strictly greater than it.
    Since there are two elements with the value 3, in total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.


    Constraints:

            1 <= nums.length <= 100
            -105 <= nums[i] <= 105
    */


    /**
     * 统计同时至少具有一个严格较小元素和一个严格较大元素的元素数目
     *
     * 先从数组中找出最大值和最小值，然后重新遍历数组，统计同时大于最小值与小于最大值的元素个数
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Elements With Strictly Smaller and Greater Elements .
     * Memory Usage: 41.7 MB, less than 22.10% of Java online submissions for Count Elements With Strictly Smaller and Greater Elements .
     *
     * @param nums
     * @return
     */
    public int countElements(int[] nums) {
        if (nums.length < 3)
            return 0;

        int ans = 0;
        int min = nums[0];
        int max = min;
        for (int i : nums) {
            if (i < min)
                min = i;
            else if (i > max)
                max = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min && nums[i] < max) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements test = new _2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements();
        System.out.println(test.countElements(new int[]{11, 7, 2, 15}));
        System.out.println(test.countElements(new int[]{-3, 3, 3, 90}));
        System.out.println(test.countElements(new int[]{-3, 3, 3, 3, 90}));
    }
}
