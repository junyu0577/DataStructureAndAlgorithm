package com.github.junyu.solution.leetCode.easy.string;


public class _796_Rotate_String {

  /*  We are given two strings, A and B.

    A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
    For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A
    can become B after some number of shifts on A.

            Example 1:
    Input: A = 'abcde', B = 'cdeab'
    Output: true

    Example 2:
    Input: A = 'abcde', B = 'abced'
    Output: false
    Note:

    A and B will have length at most 100.
*/

    /**
     * B是否是旋转过的A
     * 如果字符串长度不想等，那么就是false
     * 通过A+A 获取一个新的字符串，然后判断A是否包含有B的子串
     * 含有就返回true
     *
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        A = A + A;
        return A.contains(B);
    }

    public static void main(String[] args) {
        _796_Rotate_String rotate_string = new _796_Rotate_String();
        System.out.println(rotate_string.rotateString("abcde", "cdeab"));
        System.out.println(rotate_string.rotateString("abcde", "abced"));
        System.out.println(rotate_string.rotateString("gcmbf", "fgcmb"));
    }
}
