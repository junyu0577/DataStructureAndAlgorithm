package com.github.junyu.solution.leetCode.easy.math;

public class _171_Excel_Sheet_Column_Number {

  /*  Given a column title as appear in an Excel sheet, return its corresponding column number.

    For example:

    A -> 1
    B -> 2
    C -> 3
            ...
    Z -> 26
    AA -> 27
    AB -> 28
            ...
    Example 1:

    Input: "A"
    Output: 1
    Example 2:

    Input: "AB"
    Output: 28
    Example 3:

    Input: "ZY"
    Output: 701*/

    /**
     * Excel的列序号
     * 本质就是当作27进制转为10进制
     * s.charAt(i) * 26^0+s.charAt(i-1) * 26^1+...
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1 - i);
        }
        return sum;
    }

    public static void main(String [] args) {
        System.out.println(new _171_Excel_Sheet_Column_Number().titleToNumber("A"));
        System.out.println(new _171_Excel_Sheet_Column_Number().titleToNumber("AB"));
        System.out.println(new _171_Excel_Sheet_Column_Number().titleToNumber("ZY"));
    }
}
