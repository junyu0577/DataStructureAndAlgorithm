package com.github.junyu.solution.leetCode.easy.string;

public class _1071_Greatest_Common_Divisor_of_Strings {

    /*For strings S and T, we say "T divides S" if and only if S = T + ... + T
            (T concatenated with itself 1 or more times)

    Return the largest string X such that X divides str1 and X divides str2.



    Example 1:

    Input: str1 = "ABCABC", str2 = "ABC"
    Output: "ABC"
    Example 2:

    Input: str1 = "ABABAB", str2 = "ABAB"
    Output: "AB"
    Example 3:

    Input: str1 = "LEET", str2 = "CODE"
    Output: ""


    Note:

            1 <= str1.length <= 1000
            1 <= str2.length <= 1000
    str1[i] and str2[i] are English uppercase letters.*/

    /**
     * 字符串的最大公因子
     * 思路：如果两个s1+s2不等于s2+s1就说明不存在最大公因子，如果相等，就求最大公因子，得到结果后对str2进行截取相应的长度即可。
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
       if (!(str1+str2).equals(str2+str1))
           return "";

        return str2.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * 求最大公约数 辗转相减法
     *
     * @param value
     * @param res
     * @return
     */
    private int gcd(Integer value, int res) {
        while (true) {
            if (value > res) {
                value -= res;
            } else if (value < res) {
                res -= value;
            } else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        _1071_Greatest_Common_Divisor_of_Strings test = new _1071_Greatest_Common_Divisor_of_Strings();
        System.out.println(test.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(test.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(test.gcdOfStrings("LEET", "CODE"));
    }
}
