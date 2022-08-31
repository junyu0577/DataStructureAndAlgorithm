package com.github.junyu.solution.leetCode.easy.array;


import java.util.Arrays;

public class _2335_Minimum_Amount_of_Time_to_Fill_Cups {

    /*
    You have a water dispenser that can dispense cold, warm, and hot water. Every second, you can either fill up 2 cups with different types of water, or 1 cup of any type of water.

    You are given a 0-indexed integer array amount of length 3 where amount[0], amount[1], and amount[2] denote the number of cold, warm, and hot water cups you need to fill respectively. Return the minimum number of seconds needed to fill up all the cups.



    Example 1:

    Input: amount = [1,4,2]
    Output: 4
    Explanation: One way to fill up the cups is:
    Second 1: Fill up a cold cup and a warm cup.
            Second 2: Fill up a warm cup and a hot cup.
            Second 3: Fill up a warm cup and a hot cup.
            Second 4: Fill up a warm cup.
    It can be proven that 4 is the minimum number of seconds needed.

    Example 2:

    Input: amount = [5,4,4]
    Output: 7
    Explanation: One way to fill up the cups is:
    Second 1: Fill up a cold cup, and a hot cup.
    Second 2: Fill up a cold cup, and a warm cup.
    Second 3: Fill up a cold cup, and a warm cup.
    Second 4: Fill up a warm cup, and a hot cup.
    Second 5: Fill up a cold cup, and a hot cup.
    Second 6: Fill up a cold cup, and a warm cup.
    Second 7: Fill up a hot cup.

    Example 3:

    Input: amount = [5,0,0]
    Output: 5
    Explanation: Every second, we fill up a cold cup.


            Constraints:

    amount.length == 3
            0 <= amount[i] <= 100
    */


    /**
     *
     * 装满杯子需要的最短总时长
     * 思路就是优先接数量最多的两种水，所以在每次接之前都需要进行一次排序。
     *
     * Runtime: 1 ms, faster than 98.65% of Java online submissions for Minimum Amount of Time to Fill Cups.
     * Memory Usage: 39.8 MB, less than 98.82% of Java online submissions for Minimum Amount of Time to Fill Cups.
     * @param amount
     * @return
     */
    public int fillCups(int[] amount) {
        int ans = 0;
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            Arrays.sort(amount);
            if (amount[2] > 0 && amount[1] > 0) {
                amount[2]--;
                amount[1]--;
            } else if (amount[1] > 0 && amount[0] > 0) {
                amount[1]--;
                amount[0]--;
            } else if (amount[2] > 0 && amount[0] > 0) {
                amount[2]--;
                amount[0]--;
            } else if (amount[2] > 0) {
                amount[2]--;
            } else if (amount[1] > 0) {
                amount[1]--;
            } else if (amount[0] > 0) {
                amount[0]--;
            }
            ans++;

        }
        return ans;
    }


    public static void main(String[] args) {
        _2335_Minimum_Amount_of_Time_to_Fill_Cups test = new _2335_Minimum_Amount_of_Time_to_Fill_Cups();
        System.out.println(test.fillCups(new int[]{1, 4, 2}));
        System.out.println(test.fillCups(new int[]{5, 4, 4}));
        System.out.println(test.fillCups(new int[]{5, 0, 0}));
    }
}
