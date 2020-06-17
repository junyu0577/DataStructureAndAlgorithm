package com.github.junyu.solution.leetCode.medium.string;

public class _921_Minimum_Add_to_Make_Parentheses_Valid {

    /*Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses
            ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

    Formally, a parentheses string is valid if and only if:

    It is the empty string, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
    Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.



    Example 1:

    Input: "())"
    Output: 1
    Example 2:

    Input: "((("
    Output: 3
    Example 3:

    Input: "()"
    Output: 0
    Example 4:

    Input: "()))(("
    Output: 4


    Note:

    S.length <= 1000
    S only consists of '(' and ')' characters.*/

    /**
     * 使括号有效的最少添加
     * 思路：用total记录'('出现的次数，当遇到')'时，如果total为0，那么需要添加一个'('来匹配，
     * 否则就说明匹配上一对，total-1。遇到'('则total的数量+1。
     * 最后count+剩余的total数量即是最小要添加的数量
     * @param S
     * @return
     */
    public int minAddToMakeValid(String S) {
        int total = 0;
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                if (total > 0) {
                    total--;
                } else {
                    count++;
                }
            } else {
                total++;
            }
        }
        return count+total;
    }

    public static void main(String[] args) {
        _921_Minimum_Add_to_Make_Parentheses_Valid test = new _921_Minimum_Add_to_Make_Parentheses_Valid();
        System.out.println(test.minAddToMakeValid("())"));
        System.out.println(test.minAddToMakeValid("((("));
        System.out.println(test.minAddToMakeValid("()"));
        System.out.println(test.minAddToMakeValid("()))(("));
    }
}
