package com.github.junyu.solution.leetCode.easy.math;


public class _1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {

   /* Given an integer number n, return the difference between the product of its digits and the sum of its digits.

    Example 1:

    Input: n = 234
    Output: 15
    Explanation:
    Product of digits = 2 * 3 * 4 = 24
    Sum of digits = 2 + 3 + 4 = 9
    Result = 24 - 9 = 15
    Example 2:

    Input: n = 4421
    Output: 21
    Explanation:
    Product of digits = 4 * 4 * 2 * 1 = 32
    Sum of digits = 4 + 4 + 2 + 1 = 11
    Result = 32 - 11 = 21


    Constraints:

            1 <= n <= 10^5*/

    /**
     * 整数的各位积之差
     * 思路：通过取余的方式逐个取出数字进行乘积和求和，然后将两个结果相减
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n != 0) {
            int num = n % 10;
            n /= 10;
            product *= num;
            sum += num;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        _1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer test =
                new _1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer();
        System.out.println(test.subtractProductAndSum(234));
        System.out.println(test.subtractProductAndSum(4421));
    }
}
