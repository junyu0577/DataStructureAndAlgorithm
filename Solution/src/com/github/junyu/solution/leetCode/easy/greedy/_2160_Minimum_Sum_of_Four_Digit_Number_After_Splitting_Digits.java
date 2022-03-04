package com.github.junyu.solution.leetCode.easy.greedy;


import java.util.Arrays;

public class _2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {

    /*
    You are given a positive integer num consisting of exactly four digits. Split num into two
    new integers new1 and new2 by using the digits found in num. Leading zeros are allowed in new1
    and new2, and all the digits found in num must be used.

    For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3. Some of
    the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
    Return the minimum possible sum of new1 and new2.



    Example 1:

    Input: num = 2932
    Output: 52
    Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
    The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
    Example 2:

    Input: num = 4009
    Output: 13
    Explanation: Some possible pairs [new1, new2] are [0, 49], [490, 0], etc.
    The minimum sum can be obtained by the pair [4, 9]: 4 + 9 = 13.


    Constraints:

            1000 <= num <= 9999
    */


    /**
     * 拆分数位后四位数字的最小和
     *
     * 首先将各个位数分别加入到数组中并按升序排序，然后将第1个与第4个组合，第2个与第3个组合，相加即可得到最小和。
     *
     * Runtime: 1 ms, faster than 82.87% of Java online submissions for Minimum Sum of Four Digit Number After Splitting Digits.
     * Memory Usage: 41.1 MB, less than 50.87% of Java online submissions for Minimum Sum of Four Digit Number After Splitting Digits.
     *
     * @param num
     * @return
     */
    public int minimumSum(int num) {
        int nums [] = new int[4];
        nums[3] = num/1000;
        num%=1000;
        nums[2] = num/100;
        num%=100;
        nums[1] = num/10;
        num%=10;
        nums[0] = num;
        Arrays.sort(nums);
        return (nums[0]*10+nums[3])+(nums[1]*10+nums[2]);
    }

    public static void main(String [] args) {
        _2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits test = new _2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits();
        System.out.println(test.minimumSum(2932));
        System.out.println(test.minimumSum(4009));
    }
}
