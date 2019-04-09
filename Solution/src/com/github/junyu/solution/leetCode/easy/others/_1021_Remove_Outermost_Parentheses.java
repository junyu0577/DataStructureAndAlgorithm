package com.github.junyu.solution.leetCode.easy.others;


public class _1021_Remove_Outermost_Parentheses {

    /*
    A valid parentheses string is either empty (""), "(" + A + ")", 
    or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
    For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

    A valid parentheses string S is primitive if it is nonempty, and there does not
    exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

    Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k,
    where P_i are primitive valid parentheses strings.

    Return S after removing the outermost parentheses of every primitive string in the 
    primitive decomposition of S.



    Example 1:

    Input: "(()())(())"
    Output: "()()()"
    Explanation:
    The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
    After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
    Example 2:

    Input: "(()())(())(()(()))"
    Output: "()()()()(())"
    Explanation:
    The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
    After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
    Example 3:

    Input: "()()"
    Output: ""
    Explanation:
    The input string is "()()", with primitive decomposition "()" + "()".
    After removing outer parentheses of each part, this is "" + "" = "".


    Note:

    S.length <= 10000
    S[i] is "(" or ")"
    S is a valid parentheses string
    */

    /**
     * 去除最外层的圆括号
     * 由于是出去所有最外层包裹的圆括号，我们可以维护一个count变量，用来记录所遇到的'('的次数，当遇到'（'时，如果count大于0，
     * 说明之前只有遇到过，可以往结果里面去append，当count为0时，说明是第一次遇到，也就是说当前的字符是需要被我们移除的。
     * 同理，遇到')'时，如果count大于1，说明需要继续append有半部分去配对。count等于1时，就也是我们所要移除的元素。
     * 遇'('，count+ ;
     * 遇')', count-
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        char cs[] = S.toCharArray();
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (char c : cs) {
            if (c == '(') {
                if (count > 0)
                    ans.append(c);
                count++;
            } else if (c == ')') {
                if (count > 1)
                    ans.append(c);
                count--;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _1021_Remove_Outermost_Parentheses().removeOuterParentheses("(()())(())"));
        System.out.println(new _1021_Remove_Outermost_Parentheses().removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(new _1021_Remove_Outermost_Parentheses().removeOuterParentheses("()()"));
    }
}
