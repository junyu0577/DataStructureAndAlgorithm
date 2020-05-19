package com.github.junyu.solution.leetCode.easy.math;

public class _1295_Find_Numbers_with_Even_Number_of_Digits {

    /*Given an array nums of integers, return how many of them contain an even number of digits.

    Example 1:

    Input: nums = [12,345,2,6,7896]
    Output: 2
    Explanation:
            12 contains 2 digits (even number of digits).
            345 contains 3 digits (odd number of digits).
            2 contains 1 digit (odd number of digits).
            6 contains 1 digit (odd number of digits).
            7896 contains 4 digits (even number of digits).
    Therefore only 12 and 7896 contain an even number of digits.
    Example 2:

    Input: nums = [555,901,482,1771]
    Output: 1
    Explanation:
    Only 1771 contains an even number of digits.


    Constraints:

            1 <= nums.length <= 500
            1 <= nums[i] <= 10^5*/

    /**
     * 统计位数是偶数的数量
     * 思路：求出数字的长度，如果是偶数则喜+1
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if ((num >= 10 && num < 100) || (num >= 1000 && num < 10000)) {
                count++;
            }
        }
        return count;
    }

//    /**
//     * 统计位数是偶数的数量
//     * 思路：求出数字的长度，如果是偶数则喜+1
//     * @param nums
//     * @return
//     */
//    public int findNumbers(int[] nums) {
//        int count = 0;
//        for (int i=0;i<nums.length;i++){
//            int len = String.valueOf(nums[i]).length();
//            if ((len&1)==0){
//                count++;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        _1295_Find_Numbers_with_Even_Number_of_Digits test = new _1295_Find_Numbers_with_Even_Number_of_Digits();
        System.out.println(test.findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(test.findNumbers(new int[]{555, 901, 482, 1771}));
    }
}
