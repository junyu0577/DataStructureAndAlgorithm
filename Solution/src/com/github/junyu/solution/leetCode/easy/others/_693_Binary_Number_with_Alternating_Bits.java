package com.github.junyu.solution.leetCode.easy.others;

public class _693_Binary_Number_with_Alternating_Bits {

/*    Given a positive integer, check whether it has alternating bits: namely,
            if two adjacent bits will always have different values.

    Example 1:
    Input: 5
    Output: True
    Explanation:
    The binary representation of 5 is: 101
    Example 2:
    Input: 7
    Output: False
    Explanation:
    The binary representation of 7 is: 111.
    Example 3:
    Input: 11
    Output: False
    Explanation:
    The binary representation of 11 is: 1011.
    Example 4:
    Input: 10
    Output: True
    Explanation:
    The binary representation of 10 is: 1010.*/

    /**
     * 判断n转换为二进制后，01是否是交替位。
     * 先记录一下最低位的值，然后每次右移一位后，查看当前的最低位和上一次记录的是否相等，相同就不满足条件。
     * 不同就更新记录的值，然后继续右移后进行判断。
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int last = n & 1;
        while (n > 0) {
            n = n >> 1;
            int cur = n & 1;
            if (cur == last)
                return false;
            else {
                last = cur;
            }
        }

        return true;
    }

    public static void main(String [] args) {
        System.out.println(new _693_Binary_Number_with_Alternating_Bits().hasAlternatingBits(3));
        System.out.println(new _693_Binary_Number_with_Alternating_Bits().hasAlternatingBits(5));
        System.out.println(new _693_Binary_Number_with_Alternating_Bits().hasAlternatingBits(7));
        System.out.println(new _693_Binary_Number_with_Alternating_Bits().hasAlternatingBits(10));
    }
}
