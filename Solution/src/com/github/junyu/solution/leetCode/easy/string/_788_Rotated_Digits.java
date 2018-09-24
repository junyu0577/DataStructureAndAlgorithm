package com.github.junyu.solution.leetCode.easy.string;

public class _788_Rotated_Digits {

   /* X is a good number if after rotating each digit individually by 180 degrees, we get
    a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

    A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to
        themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest
    of the numbers do not rotate to any other number and become invalid.

    Now given a positive number N, how many numbers X from 1 to N are good?

    Example:
    Input: 10
    Output: 4
    Explanation:
    There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
    Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
            Note:

    N  will be in range [1, 10000].
*/

    /**
     * 旋转数字，对每一位数进行180度旋转，如果是其实有数字为3，4，7，那么旋转后的数字无效。
     * 如果为2，5，6，9，那么旋转后，为有效数字。0，1，8旋转后为自身，我们不需要考虑进来。
     *
     * 最简单的办法就是不断的获取最低位，取模运算获取。然后判断最低位的数字是否为2，5，6，9，如果是则说明数字近乎有效，如果
     * 整个数字中不包含3，4，7，那么就是一个有效数字。
     *
     * @param N
     * @return
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 2; i <= N; i++) {
            int cur = i;
            boolean isDiff = false;
            while (cur != 0) {
                int res = cur % 10;
                if (res == 3 || res == 4 || res == 7) {
                    isDiff = false;
                    break;
                }
                if (res == 2 || res == 5 || res == 6 || res == 9) {
                    isDiff = true;
                }
                cur = cur / 10;
            }
            if (isDiff) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _788_Rotated_Digits().rotatedDigits(20));
    }

}
