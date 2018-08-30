package com.github.junyu.solution.leetCode.easy.math;

public class _009_Palindrome_Number {

   /* Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

            Example 1:

    Input: 121
    Output: true
    Example 2:

    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    Follow up:

    Coud you solve it without converting the integer to a string?*/

//    /**
//     * 判断一个数是否是回文
//     * 将数字转字符串进行头尾比较
//     * @param x
//     * @return
//     */
//    public boolean isPalindrome(int x) {
//        if (x < 0)
//            return false;
//
//        String str = String.valueOf(x);
//        char cs[] = str.toCharArray();
//        int mid = cs.length / 2;
//        for (int i = 0; i < mid; i++) {
//            if (cs[i] != cs[cs.length - 1 - i])
//                return false;
//        }
//        return true;
//    }

    /**
     * 题目要求别用转字符串的方式实现
     * 定一个rev变量，rev最终保存x的右半边的反转结果，如果是回文，那么最终x会和rev相等，如果rev的值大过x ，那么x肯定不和rev相等
     * ，需要对rev/10后，再判断是否和x相等。如121，x=1，rev=12，需要对rev/10。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))//排除负数与10的倍数
            return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x/=10;
        }

        return x==rev | x==rev/10;
    }

    public static void main(String[] args) {
        System.out.println(new _009_Palindrome_Number().isPalindrome(121));
        System.out.println(new _009_Palindrome_Number().isPalindrome(-121));
        System.out.println(new _009_Palindrome_Number().isPalindrome(0));
        System.out.println(new _009_Palindrome_Number().isPalindrome(9999));

    }
}
