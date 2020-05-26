package com.github.junyu.solution.leetCode.easy.array;


public class _509_Fibonacci_Number {

    /*The Fibonacci numbers, commonly denoted F(n) form a sequence,
    called the Fibonacci sequence, such that each number is the sum of the
    two preceding ones, starting from 0 and 1. That is,

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), for N > 1.
    Given N, calculate F(N).



    Example 1:

    Input: 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    Example 2:

    Input: 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
    Example 3:

    Input: 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


    Note:

            0 ≤ N ≤ 30.*/

    /**
     * 斐波那契数列
     * 思路：利用动态规划减少重复的递归计算
     * @param N
     * @return
     */
    public int fib(int N) {
        return fib(new int[N + 1], N);
    }

    public int fib(int[] dp, int N) {
        if (N == 0)
            return 0;

        if (N == 1 || N == 2)
            return 1;

        if (dp[N]==0)
            dp[N] = fib(dp,N-1)+fib(dp,N-2);


        return dp[N];
    }


    public static void main(String[] args) {
        _509_Fibonacci_Number test = new _509_Fibonacci_Number();
        System.out.println(test.fib(2));
        System.out.println(test.fib(3));
        System.out.println(test.fib(4));

    }
}
