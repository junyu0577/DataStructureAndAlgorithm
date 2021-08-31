package com.github.junyu.solution.leetCode.easy.array;


public class _1979_Find_Greatest_Common_Divisor_of_Array {

/*
    Given an integer array nums, return the greatest common divisor of the
     smallest number and largest number in nums.

    The greatest common divisor of two numbers is the largest positive
    integer that evenly divides both numbers.



    Example 1:

    Input: nums = [2,5,6,9,10]
    Output: 2
    Explanation:
    The smallest number in nums is 2.
    The largest number in nums is 10.
    The greatest common divisor of 2 and 10 is 2.

    Example 2:

    Input: nums = [7,5,6,8,3]
    Output: 1
    Explanation:
    The smallest number in nums is 3.
    The largest number in nums is 8.
    The greatest common divisor of 3 and 8 is 1.

    Example 3:

    Input: nums = [3,3]
    Output: 3
    Explanation:
    The smallest number in nums is 3.
    The largest number in nums is 3.
    The greatest common divisor of 3 and 3 is 3.


    Constraints:

            2 <= nums.length <= 1000
            1 <= nums[i] <= 1000
    */

    /**
     * 返回数组中最大数和最小数的 最大公约数 。
     *
     * 先遍历一遍数组找出最大数与最小数，然后使用辗转相减法求最大公约数。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Greatest Common Divisor of Array.
     * Memory Usage: 38.6 MB, less than 82.91% of Java online submissions for Find Greatest Common Divisor of Array.
     *
     * @param nums
     * @return
     */
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        return gcd(max,min);
    }

    private int gcd(int num, int num2) {
        if (num2==0)
            return 0;

        while (true){
            if (num>num2){
                num = num-num2;
            }else if (num<num2){
                num2 = num2-num;
            }else {
                return num;
            }
        }
    }

    public static void main(String [] args) {
        _1979_Find_Greatest_Common_Divisor_of_Array test = new _1979_Find_Greatest_Common_Divisor_of_Array();
        System.out.println(test.findGCD(new int[]{2,5,6,9,10}));
        System.out.println(test.findGCD(new int[]{7,5,6,8,3}));
        System.out.println(test.findGCD(new int[]{3,3}));
    }
}
