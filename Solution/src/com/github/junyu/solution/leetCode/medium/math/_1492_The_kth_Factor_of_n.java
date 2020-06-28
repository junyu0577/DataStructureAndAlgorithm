package com.github.junyu.solution.leetCode.medium.math;

public class _1492_The_kth_Factor_of_n {

    /*Given two positive integers n and k.

    A factor of an integer n is defined as an integer i where n % i == 0.

    Consider a list of all factors of n sorted in ascending order, return the kth factor
     in this list or return -1 if n has less than k factors.

    Example 1:

    Input: n = 12, k = 3
    Output: 3
    Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
    Example 2:

    Input: n = 7, k = 2
    Output: 7
    Explanation: Factors list is [1, 7], the 2nd factor is 7.
    Example 3:

    Input: n = 4, k = 4
    Output: -1
    Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
    Example 4:

    Input: n = 1, k = 1
    Output: 1
    Explanation: Factors list is [1], the 1st factor is 1.
    Example 5:

    Input: n = 1000, k = 3
    Output: 4
    Explanation: Factors list is [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000].


    Constraints:

            1 <= k <= n <= 1000*/

    /**
     * n 的第 k 个因子
     * 思路：从1遍历到n，如果i能被n整除就将count+1，当count==k时，当前的i就是第k个因子。
     * @param n
     * @param k
     * @return
     */
    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i=1;i<=n;i++){
            if (n%i==0)
                count++;

            if (count==k)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _1492_The_kth_Factor_of_n test = new _1492_The_kth_Factor_of_n();
        System.out.println(test.kthFactor(12,3));
        System.out.println(test.kthFactor(7,2));
        System.out.println(test.kthFactor(4,4));
        System.out.println(test.kthFactor(1,1));
        System.out.println(test.kthFactor(1000,3));
    }
}
