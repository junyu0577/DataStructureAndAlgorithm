package com.github.junyu.solution.leetCode.medium.math;

public class _050_Pow_x_n {

    /*Implement pow(x, n), which calculates x raised to the power n (xn).

    Example 1:

    Input: 2.00000, 10
    Output: 1024.00000
    Example 2:

    Input: 2.10000, 3
    Output: 9.26100
    Example 3:

    Input: 2.00000, -2
    Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25
    Note:

            -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−231, 231 − 1]*/

    private boolean isError;

    /**
     * 求x的n次方
     * 对0求倒数没有意义，以及0的0次方，都直接就返回0
     * 利用递归求次方比如求32次方，那么可以通过16次方的再次方，求16的次方可以通过8的次方再次方。
     * 当次方数为奇数时，还需要额外乘上一个x。得到次方的解后，需要查看n是否小于0，如果小于0，就说明还要求一下倒数。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0 && n < 0) {
            isError = true;
            return 0.0;
        }

        if (n == Integer.MIN_VALUE) {
            x = Math.abs(x);
            if (x == 1)
                return 1.0;
            return 0.0;
        }

        int absN = n;

        if (absN < 0)
            absN = Math.abs(absN);

        double result = powOf(x, absN);

        if (n < 0) {
            result = 1.0 / result;
        }

        return result;

    }

    private double powOf(double x, int n) {
        if (n == 0)
            return 1;

        if (n == 1)
            return x;

        double res = powOf(x, n >> 1);
        res *= res;
        if ((n & 1) == 1)
            res *= x;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _050_Pow_x_n().myPow(2.00000, 10));
        System.out.println(new _050_Pow_x_n().myPow(2.10000, 3));
        System.out.println(new _050_Pow_x_n().myPow(2.00000, -2));
        System.out.println(new _050_Pow_x_n().myPow(1.00000, -2147483648));
        System.out.println(new _050_Pow_x_n().myPow(-1.00000, -2147483648));

    }


}
