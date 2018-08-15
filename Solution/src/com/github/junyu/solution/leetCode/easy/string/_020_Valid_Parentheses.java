package com.github.junyu.solution.leetCode.easy.string;

import java.util.Stack;


/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/30 19:29
 */
public class _020_Valid_Parentheses {

  /*  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

            Example 1:

    Input: "()"
    Output: true
    Example 2:

    Input: "()[]{}"
    Output: true
    Example 3:

    Input: "(]"
    Output: false
    Example 4:

    Input: "([)]"
    Output: false
    Example 5:

    Input: "{[]}"
    Output: true*/

    /**
     * 每遇到([{等符号就往栈中push他对应的结束符，由于整个字符串只存在这些字符，
     * 那么整体就只有4种可能，只要不是结束符的情况就进行比对，栈中为空或者内容不一致，
     * 那么整个字符串就是不合法的。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='{')
                stack.push('}');
            else if (c=='[')
                stack.push(']');
            else if (c=='(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop()!=c)
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("]"));
    }

}
