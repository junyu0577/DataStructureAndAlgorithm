package com.github.junyu.solution.leetCode.easy.string;

/**
 * @author ShaoJunyu
 * @since 2018/6/14 09:15
 */
public class _003_ReverseInteger {

   /*
    Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:

    Input: 123
    Output: 321
    Example 2:

    Input: -123
    Output: -321
    Example 3:

    Input: 120
    Output: 21
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

    */

    /**
     * 利用取余和取商得方法，使用while每次对输入得数进行/10操作，直到最后/10得结果为0结束。
     * 在循环体中每次对事先定义得result进行*10+余数累增，得出翻转后得结果，加入最大值和最小值
     * 得判断防止超出边界
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;

            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }

            result = result * 10 + remainder;

        }

        return result;
    }

    public static void main(String[] args) {
        int num = 123;
//        int num = -123;
//        int num = 110;
//        int num = -2147483648;
//        int num = 2147483647;
        System.out.println(reverse(num));
    }
}
