package com.github.junyu.solution.leetCode.easy.string;

public class _1556_Thousand_Separator {

    /*Given an integer n, add a dot (".") as the thousands separator and return it in string format.

    Example 1:

    Input: n = 987
    Output: "987"
    Example 2:

    Input: n = 1234
    Output: "1.234"
    Example 3:

    Input: n = 123456789
    Output: "123.456.789"
    Example 4:

    Input: n = 0
    Output: "0"


    Constraints:

            0 <= n < 2^31*/

    /**
     * 千分分割数字
     * 思路：将数字转为字符串，然后倒着遍历添加进StringBuilder中，每添加进三个的同时在末尾追加一个'.'字符，最后判断末尾的字符是否为点，如果是点就要删除，
     * 最终需要将内容再翻转一下返回。
     * @param n
     * @return
     */
    public String thousandSeparator(int n) {
        String str = String.valueOf(n);
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            ans.append(str.charAt(i));
            count++;
            if (count == 3) {
                count = 0;
                ans.append('.');
            }
        }

        if (ans.charAt(ans.length()-1)=='.'){
            ans.deleteCharAt(ans.length()-1);
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        _1556_Thousand_Separator test = new _1556_Thousand_Separator();
        System.out.println(test.thousandSeparator(987));
        System.out.println(test.thousandSeparator(1234));
        System.out.println(test.thousandSeparator(123456789));
        System.out.println(test.thousandSeparator(0));
    }

}
