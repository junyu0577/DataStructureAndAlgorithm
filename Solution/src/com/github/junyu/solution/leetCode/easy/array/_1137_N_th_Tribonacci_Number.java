package com.github.junyu.solution.leetCode.easy.array;

public class _1137_N_th_Tribonacci_Number {

    /*The Tribonacci sequence Tn is defined as follows:

    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

    Given n, return the value of Tn.



    Example 1:

    Input: n = 4
    Output: 4
    Explanation:
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4
    Example 2:

    Input: n = 25
    Output: 1389537


    Constraints:

            0 <= n <= 37
    The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.*/

    /**
     * 第 N 个泰波那契数
     * 思路：由于第n项是前三项之和，因此不断的求出第n项的和然后再更新最后三项的值即可。
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0 || n == 1)
            return n;

        if (n == 2)
            return 1;

        int n1 = 0, n2 = 1, n3 = 1;

        for (int i = 3; i <= n; i++) {
            int sum = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = sum;
        }
        return n3;
    }

    public static void main(String[] args) {
        _1137_N_th_Tribonacci_Number test = new _1137_N_th_Tribonacci_Number();
        System.out.println(test.tribonacci(4));
        System.out.println(test.tribonacci(25));
    }
}
