package com.github.junyu.solution.leetCode.easy.math;

public class _231_Power_of_Two {

   /* Given an integer, write a function to determine if it is a power of two.

    Example 1:

    Input: 1
    Output: true
    Explanation: 2^0 = 1
    Example 2:

    Input: 16
    Output: true
    Explanation: 2^4 = 16
    Example 3:

    Input: 218
    Output: false*/

    /**
     * 判断n是否是2的n次方
     * 将i初始化定义为1，1是0次方，正确。
     * 如果n是大于1的值，那么不断的将i左移一位，当i>=n的时候，循环结束，再判断i和n是否相等。
     * 左移的时候有可能会超出int边界，会归零。当i=0的时候，要么是整形溢出，要么就是输入的是0，这两个都不是2的n次方数。
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        int i = 1;
        while (i < n && i != 0) {
            i = i << 1;
        }
        return i == n;
    }

    public static void main(String[] args) {
        System.out.println(new _231_Power_of_Two().isPowerOfTwo(0));
        System.out.println(new _231_Power_of_Two().isPowerOfTwo(1));
        System.out.println(new _231_Power_of_Two().isPowerOfTwo(16));
        System.out.println(new _231_Power_of_Two().isPowerOfTwo(218));
        System.out.println(new _231_Power_of_Two().isPowerOfTwo(1073741825));
    }

}
