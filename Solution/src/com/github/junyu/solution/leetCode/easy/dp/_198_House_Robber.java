package com.github.junyu.solution.leetCode.easy.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaoJunyu
 * @since 2018/8/3 08:11
 */
public class _198_House_Robber {


   /* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will
    automatically contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
    you can rob tonight without alerting the police.

            Example 1:

    Input: [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.
    Example 2:

    Input: [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    Total amount you can rob = 2 + 9 + 1 = 12.
    */

    private int[] memo;

    /**
     * 尝试偷取[i...nums.length-1]
     * memo[i] 为从[i...nums.length-1]可获取的最大价值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return tryToRob(nums, 0);
    }

    private int tryToRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryToRob(nums, i + 2));
            memo[index] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3, 1});
        list.add(new int[]{2, 7, 9, 3, 1});
        list.add(new int[]{2, 1, 1, 2});

        _198_House_Robber house_robber = new _198_House_Robber();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(house_robber.rob(list.get(i)));
        }
    }

}
