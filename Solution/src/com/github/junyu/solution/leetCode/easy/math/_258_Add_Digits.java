package com.github.junyu.solution.leetCode.easy.math;

public class _258_Add_Digits {


   /* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

    Example:

    Input: 38
    Output: 2
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
    Since 2 has only one digit, return it.
    Follow up:
    Could you do it without any loop/recursion in O(1) runtime?*/

    /**
     * 对数字里的包含的数进行求和，直到数字只剩下个位数，即求数根
     * 原始过程解法,只要num大于9，就将各位数字相加
     *
     * @param num
     * @return
     */
//    public int addDigits(int num) {
//        while (num > 9) {
//            int sum = 0;
//            int cur = num;
//            while (cur > 0) {
//                sum += cur % 10;
//                cur = cur / 10;
//            }
//            num = sum;
//        }
//        return num;
//    }

    /**
     * 求树根公式,num%9,9的根仍然是9，但是9mod9为0，然后对计算公式改为（num-1）%9+1
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new _258_Add_Digits().addDigits(38));
        System.out.println(new _258_Add_Digits().addDigits(10));
    }
}
