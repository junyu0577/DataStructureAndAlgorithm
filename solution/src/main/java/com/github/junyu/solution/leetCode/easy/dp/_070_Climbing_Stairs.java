package com.github.junyu.solution.leetCode.easy.dp;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/8/1 20:47
 */
public class _070_Climbing_Stairs {

   /* You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can
    you climb to the top?

    Note: Given n will be a positive integer.

            Example 1:

        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
        Example 2:

        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step*/


//    private int memo[];
//
//    /**
//     * 利用递归 记忆化搜索
//     * @param n
//     * @return
//     */
//    public int climbStairs(int n) {
//
//        if (n == 1)
//            return 1;
//
//        memo = new int[n + 1];
//        for (int i = 0; i < memo.length; i++)
//            memo[i] = -1;
//
//        memo[1] = 1;
//        memo[2] = 2;
//
//        return count(n);
//
//    }
//
//    private int count(int n) {
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//
//        if (memo[n] == -1)
//            memo[n] = count(n - 1) + count(n - 2);
//
//        return memo[n];
//    }

        /**
     * 爬1阶有1中，2有2，3有1+2,n就有(n-1)+(n-2)
     * 动态规划 - 自底向上
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        int memo[] = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];

    }

    public static void main(String[] args) {
        _070_Climbing_Stairs climbing_stairs = new _070_Climbing_Stairs();
        System.out.println(climbing_stairs.climbStairs(1));
        System.out.println(climbing_stairs.climbStairs(2));
        System.out.println(climbing_stairs.climbStairs(3));
        System.out.println(climbing_stairs.climbStairs(10));
    }

}
