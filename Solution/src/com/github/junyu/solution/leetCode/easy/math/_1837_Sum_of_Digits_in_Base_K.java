package com.github.junyu.solution.leetCode.easy.math;

public class _1837_Sum_of_Digits_in_Base_K {

    /*
    Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10
    to base k.

    After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.

    Example 1:
    Input: n = 34, k = 6
    Output: 9
    Explanation: 34 (base 10) expressed in base 6 is 54. 5 + 4 = 9.


    Example 2:
    Input: n = 10, k = 10
    Output: 1
    Explanation: n is already in base 10. 1 + 0 = 1.


    Constraints:

            1 <= n <= 100
            2 <= k <= 10
    */

    /**
     * K 进制表示下的各位数字总和,先将n转为k进制数，然后累加各位数得总和。
     *
     * 将情况分别两种，一种是10进制，当处理10进制时，就不需要做换算，直接通过mod取出各位数并累加即可。
     * 另一种是其他进制得，那么问题就变成了进制转换，累加 n mod k 的余数。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Digits in Base K.
     * Memory Usage: 37.5 MB, less than 27.33% of Java online submissions for Sum of Digits in Base K.
     * @param n
     * @param k
     * @return
     */
    public int sumBase(int n, int k) {
        int ans = 0;

        if (k!=10){
            while (n > 0) {
                int mod = n%k;
                n/=k;
                ans = mod+ans;
            }
        } else {
            while (n != 0) {
                int digit = n % 10;
                n /= 10;
                ans += digit;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1837_Sum_of_Digits_in_Base_K test = new _1837_Sum_of_Digits_in_Base_K();
        System.out.println(test.sumBase(34, 6));
        System.out.println(test.sumBase(10,10));

    }
}
