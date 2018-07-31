package com.github.junyu.solution.leetCode.easy.others;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/31 18:57
 */
public class _191_Number_of_1_Bits {

 /*   Write a function that takes an unsigned integer and returns the number of '1' bits
    it has (also known as the Hamming weight).

    Example 1:

    Input: 11
    Output: 3
    Explanation: Integer 11 has binary representation 00000000000000000000000000001011
    Example 2:

    Input: 128
    Output: 1
    Explanation: Integer 128 has binary representation 00000000000000000000000010000000*/

    /**
     * 求出n的二进制数中含有几个1
     *
     * 不断的将n与n-1进行与运算，每次留下同位的1，直到二进制中只剩下0结束
     * @param n
     * @return
     */
    public static  int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String [] args){
//        System.out.println(hammingWeight(0));
//        System.out.println(hammingWeight(1));
//        System.out.println(hammingWeight(2));
//        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
    }
}
