package com.github.junyu.solution.leetCode.easy.others;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/31 20:34
 */
public class _461_Hamming_Distance {

 /*   The Hamming distance between two integers is the number of positions at
    which the corresponding bits are different.

    Given two integers x and y, calculate the Hamming distance.

            Note:
            0 ≤ x, y < 231.

    Example:

    Input: x = 1, y = 4

    Output: 2

    Explanation:
            1   (0 0 0 1)
            4   (0 1 0 0)
            ↑   ↑

    The above arrows point to positions where the corresponding bits are different.*/

    /**
     * 这题要求计算给定的两个值转换成二进制后，找到同位不同数的数量。
     * 通过异或运算，然后里面1个个数就是结果。
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count += xor & 1;//依次进行低位比较
            xor = xor >> 1;//右移，直到xor变成0
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }


}
