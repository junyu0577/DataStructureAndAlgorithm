package com.github.junyu.solution.leetCode.easy.others;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/31 22:38
 */
public class _190_Reverse_Bits {

  /*  Reverse bits of a given 32 bits unsigned integer.

            Example:

    Input: 43261596
    Output: 964176192
    Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
            return 964176192 represented in binary as 00111001011110000010100101000000.
    Follow up:
    If this function is called many times, how would you optimize it?*/

    /**
     * 不断的查看n的低位是否为1，然后右移。
     * 低位遇到1就把res左移后再+1，否则就只是做左移操作。
     *
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {//低位为1
                res = (res << 1) + 1;
            } else {
                res = res << 1;
            }

            n = n >> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(1));
    }

}
