package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _628_Maximum_Product_of_Three_Numbers {

   /* Given an integer array, find three numbers whose product is maximum and output the maximum product.

            Example 1:
    Input: [1,2,3]
    Output: 6
    Example 2:
    Input: [1,2,3,4]
    Output: 24
    Note:
    The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
    Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.*/

//    /**
//     * 数组中找到三个数的最大乘积
//     * 对数组做一次排序，考虑有负数的存在，那么只要0和1位置的乘积大于倒数二三的乘积，那么三个数分别是0，1，最后一位。
//     * 否则就是最后三位
//     *
//     * @param nums
//     * @return
//     */
//    public int maximumProduct(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length - 1;
//        return Math.max(nums[len] * nums[0] * nums[1], nums[len] * nums[nums.length - 2] * nums[nums.length - 3]);
//    }

    /**
     * 解法二
     * 由于sort的操作是基于快排时间复杂度是o(nlogn)，我们其实可以用n的复杂度来优化这里
     * 我们定义max1 max2 max3分别存放第三 第二 第一大值，以及min1 min2 存放最小 次小
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i > max1) {//大于max1，那么3个max都需要进行更新
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {//大于max2，只需要更新max3和max2
                max3 = max2;
                max2 = i;
            } else if (i > max3) {//大于max3，只需更新max3
                max3 = i;
            }

            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }

        return Math.max(max1 * min1 * min2, max3 * max2 * max1);

    }

    public static void main(String[] args) {
//        int arr [] = {1,2,3};
//        int arr [] = {1,2,3,4};
//        int arr[] = {-7, -6, 3, 4, 5};
        int arr[] = {903, 606, 48, -474, 313, -672, 872, -833, 899, -629, 558, -368, 231, 621, 716, -41, -418, 204, -1, 883, 431, 810, 452, -801, 19, 978, 542, 930, 85, 544, -784, -346, 923, 224, -533, -473, 499, -439, -925, 171, -53, 247, 373, 898, 700, 406, -328, -468, 95, -110, -102, -719, -983, 776, 412, -317, 606, 33, -584, -261, 761, -351, -300, 825, 224, 382, -410, 335, 187, 880, -762, 503, 289, -690, 117, -742, 713, 280, -781, 447, 227, -579, -845, -526, -403, -714, -154, 960, -677, 805, 230, 591, 442, -458, -905, 832, -285, 511, 536, -86};
        _628_Maximum_Product_of_Three_Numbers maximum_product_of_three_numbers = new _628_Maximum_Product_of_Three_Numbers();
        System.out.println(maximum_product_of_three_numbers.maximumProduct(arr));
    }

}
