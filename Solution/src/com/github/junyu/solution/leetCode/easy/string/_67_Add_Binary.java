package com.github.junyu.solution.leetCode.easy.string;


public class _67_Add_Binary {

    /*Given two binary strings, return their sum (also a binary string).

    The input strings are both non-empty and contains only characters 1 or 0.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"
    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"


    Constraints:

    Each string consists only of '0' or '1' characters.
    1 <= a.length, b.length <= 10^4
    Each string is either "0" or doesn't contain any leading zero.*/

    /**
     * 二进制求和
     * 思路：为字符串末尾开始进行配对进行求和（需要带上上一次求和的累进），求和的结果只有两种可能，一种是大于1，无论是2还是3，对于下一次
     * 的累进必然都是1，当前的结果为(和%2)，另一种就是没有累进的。将结果都追加进sb中。
     * 由于存在长短不一问题，当另一个数组的长度不足时，默认与'0'求进行求和.
     * 最后将sb反转得到最终结果。
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int left = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            char aChar = aIndex < 0 ? '0' : a.charAt(aIndex);
            char bChar = bIndex < 0 ? '0' : b.charAt(bIndex);
            int res = (aChar - '0') + (bChar - '0') + left;
            if (res > 1) {
                sb.append(res % 2);
                left = 1;
            } else {
                left = 0;
                sb.append(res);
            }
            aIndex--;
            bIndex--;
        }

        if (left > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        _67_Add_Binary test = new _67_Add_Binary();
        System.out.println(test.addBinary("11", "1"));
        System.out.println(test.addBinary("1010", "1011"));
        System.out.println(test.addBinary("100", "110010"));
        System.out.println(test.addBinary("1", "111"));
        System.out.println(test.addBinary("101111", "10"));
    }
}
