package com.github.junyu.solution.leetCode.medium.other;

public class _856_Score_of_Parentheses {

    /*Given a balanced parentheses string S, compute the score of the string based on the following rule:

            () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
            (A) has score 2 * A, where A is a balanced parentheses string.


            Example 1:

    Input: "()"
    Output: 1
    Example 2:

    Input: "(())"
    Output: 2
    Example 3:

    Input: "()()"
    Output: 2
    Example 4:

    Input: "(()(()))"
    Output: 6


    Note:

    S is a balanced parentheses string, containing only ( and ).
            2 <= S.length <= 50*/

    /**
     * 统一字符串中括号的总分 单一括号为1分、连续相连的括号得（A+B）分，嵌套的括号得2*（A）分
     * 遍历S字符串，只有遇到')'符号并且前一个是'('符号才计算对应的score，因为嵌套的括号是双倍的分，
     * 所以每次遇到'('需要对tempScore,进行翻倍处理。
     * 每次遇到')'符号时同时也需要对tempScore进行/2处理，遍历结束tempScore也就重置为0.
     *
     * @param S
     * @return
     */
    public int scoreOfParentheses(String S) {

        int res = 0;
        int tempScore = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                tempScore += tempScore == 0 ? 1 : tempScore;
            } else {
                if (S.charAt(i - 1) == '(') {
                    res += tempScore;
                }
                tempScore >>= 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _856_Score_of_Parentheses score_of_parentheses = new _856_Score_of_Parentheses();
        System.out.println(score_of_parentheses.scoreOfParentheses("()"));
        System.out.println(score_of_parentheses.scoreOfParentheses("(())"));
        System.out.println(score_of_parentheses.scoreOfParentheses("()()"));
        System.out.println(score_of_parentheses.scoreOfParentheses("(()(()))"));
        System.out.println(score_of_parentheses.scoreOfParentheses("(()())"));
    }


}
