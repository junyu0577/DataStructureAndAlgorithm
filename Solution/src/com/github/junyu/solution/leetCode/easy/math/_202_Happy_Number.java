package com.github.junyu.solution.leetCode.easy.math;

import java.util.HashSet;

public class _202_Happy_Number {

  /*  Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer,
    replace the number by the sum of the squares of its digits, and repeat the process until
    the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy numbers.

            Example:

    Input: 19
    Output: true
    Explanation:
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1*/

    /**
     * 求一个数是否是快乐数
     * 一个“快乐数”定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     * 因为考虑到如果一个数不是快乐数，就会出现无限循环的情况，所以建立一个hashSet保存每次计算后的结果，如果新的计算结果
     * 在set中已经存在，那么这个数必然不是快乐数。
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;

        HashSet<Integer> set = new HashSet<>();

        while (set.add(n)) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10 * (n % 10);
                n /= 10;
            }

            if (sum == 1)
                return true;
            else
                n = sum;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _202_Happy_Number().isHappy(19));
        System.out.println(new _202_Happy_Number().isHappy(7));
        System.out.println(new _202_Happy_Number().isHappy(2));
    }


}
