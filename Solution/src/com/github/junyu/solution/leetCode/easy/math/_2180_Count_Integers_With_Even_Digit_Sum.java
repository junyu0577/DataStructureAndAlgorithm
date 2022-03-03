package com.github.junyu.solution.leetCode.easy.math;

public class _2180_Count_Integers_With_Even_Digit_Sum {

    /*
    Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.

    The digit sum of a positive integer is the sum of all its digits.



    Example 1:

    Input: num = 4
    Output: 2
    Explanation:
    The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
    Example 2:

    Input: num = 30
    Output: 14
    Explanation:
    The 14 integers less than or equal to 30 whose digit sums are even are
    2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.


    Constraints:

            1 <= num <= 1000
    */


    /**
     * 统计各位数字之和是偶数的个数
     *
     * 从num开始依次往下遍历，拆分出每个数字的各个位数然后相加，如果结果是偶数就累加ans
     *
     * Runtime: 1 ms, faster than 88.29% of Java online submissions for Count Integers With Even Digit Sum.
     * Memory Usage: 39.1 MB, less than 91.48% of Java online submissions for Count Integers With Even Digit Sum.
     *
     * @param num
     * @return
     */
    public int countEven(int num) {
        int ans = 0;
        while (num>=2){
            int total = 0;
            int cur = num;
            while (cur>0){
                total+=cur%10;
                cur/=10;
            }
            if ((total&1)==0)
                ans++;

            num--;
        }

        return ans;
    }


    public static void main(String [] args) {
        _2180_Count_Integers_With_Even_Digit_Sum test = new _2180_Count_Integers_With_Even_Digit_Sum();
        System.out.println(test.countEven(4));
        System.out.println(test.countEven(30));
    }
}
