package com.github.junyu.solution.leetCode.easy.string;

public class _1614_Maximum_Nesting_Depth_of_the_Parentheses {

    /*A string is a valid parentheses string (denoted VPS) if it meets one of the following:

    It is an empty string "", or a single character not equal to "(" or ")",
    It can be written as AB (A concatenated with B), where A and B are VPS's, or
    It can be written as (A), where A is a VPS.
    We can similarly define the nesting depth depth(S) of any VPS S as follows:

    depth("") = 0
    depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
    depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
    depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
    For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

    Given a VPS represented as string s, return the nesting depth of s.

    Example 1:

    Input: s = "(1+(2*3)+((8)/4))+1"
    Output: 3
    Explanation: Digit 8 is inside of 3 nested parentheses in the string.

    Example 2:

    Input: s = "(1)+((2))+(((3)))"
    Output: 3

    Example 3:

    Input: s = "1+(2*3)/(2-1)"
    Output: 1

    Example 4:

    Input: s = "1"
    Output: 0


    Constraints:

    1 <= s.length <= 100
    s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
    It is guaranteed that parentheses expression s is a VPS.*/

    /**
     * 括号的最大嵌套深度
     * 每次遇到'('就递增深度值，遇到')'先判断当前深度是否大于0，如果大于0就将深度值递减。
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        int depth = 0;
        int ans = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                depth++;
                ans = Math.max(ans,depth);
            }else if (c==')'){
                if (depth>0){
                    depth--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _1614_Maximum_Nesting_Depth_of_the_Parentheses test = new _1614_Maximum_Nesting_Depth_of_the_Parentheses();
        System.out.println(test.maxDepth(""));
        System.out.println(test.maxDepth("(1)"));
        System.out.println(test.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(test.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(test.maxDepth("1+(2*3)/(2-1)"));
        System.out.println(test.maxDepth("1"));


    }
}
