package com.github.junyu.solution.leetCode.easy.array;

public class _2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array {


//    给你一个正整数数组 nums 。
//
//    元素和 是 nums 中的所有元素相加求和。
//    数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
//    返回 元素和 与 数字和 的绝对差。
//
//    注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
//
//             
//
//    示例 1：
//
//    输入：nums = [1,15,6,3]
//    输出：9
//    解释：
//    nums 的元素和是 1 + 15 + 6 + 3 = 25 。
//    nums 的数字和是 1 + 1 + 5 + 6 + 3 = 16 。
//    元素和与数字和的绝对差是 |25 - 16| = 9 。
//    示例 2：
//
//    输入：nums = [1,2,3,4]
//    输出：0
//    解释：
//    nums 的元素和是 1 + 2 + 3 + 4 = 10 。
//    nums 的数字和是 1 + 2 + 3 + 4 = 10 。
//    元素和与数字和的绝对差是 |10 - 10| = 0 。
//             
//
//    提示：
//
//            1 <= nums.length <= 2000
//            1 <= nums[i] <= 2000


    /**
     * 数组元素和与数字和的绝对差
     * 数字和的求法就是通过不断求模并除10来获得各个位数。
     * 最后求元素和与数字和的差值的绝对值。
     *
     * @param nums
     * @return
     */
    public int differenceOfSum(int[] nums) {
        int num = 0, num2 = 0;
        for (int i : nums) {
            num += i;

            while (i > 0) {
                num2 += i % 10;
                i /= 10;
            }
        }
        return Math.abs(num - num2);
    }


    public static void main(String[] args) {
        _2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array test = new _2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array();
        System.out.println(test.differenceOfSum(new int[]{1, 15, 6, 3}));
        System.out.println(test.differenceOfSum(new int[]{1, 2, 3, 4}));
    }
}
