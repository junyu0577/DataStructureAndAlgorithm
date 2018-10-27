package com.github.junyu.solution.leetCode.easy.others;

public class _476_Number_Complement {

   /* Given a positive integer, output its complement number. The complement strategy
    is to flip the bits of its binary representation.

    Note:
    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.
            Example 1:
    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010.
    So you need to output 2.
    Example 2:
    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0.
    So you need to output 0.*/

    /**
     * 求一个数的补数
     * 对num进行遍历，每次和1进行与运算，查看最低位是否为0，因为求补数，所以当为0的时候，就累加2的pow次方，
     * 直到num为0，循环结束，res的结果就是num的补数。
     * @param num
     * @return
     */
    public int findComplement(int num) {

        int res = 0;

        int pow = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                res += Math.pow(2, pow);
            }
            pow++;
            num = num >> 1;
        }

        return res;

    }

    public static void main(String[] args) {
        _476_Number_Complement number_complement = new _476_Number_Complement();
        System.out.println(number_complement.findComplement(1));
        System.out.println(number_complement.findComplement(2));
        System.out.println(number_complement.findComplement(3));
        System.out.println(number_complement.findComplement(5));
    }


}
